package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.AutoService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autos")
public class AutoController {
    private static final Logger logger= LogManager.getLogger(AutoController.class);
    @Autowired
    private AutoService autoService= new AutoService();
    @PostMapping
    public ResponseEntity<Auto> registrarAuto(@RequestBody Auto auto){
        logger.info("Llego la peticion de registrar el auto: "+auto);
        return ResponseEntity.ok(autoService.guardarAuto(auto));
    }
    @PutMapping
    public ResponseEntity<String> actualizarAuto(@RequestBody Auto auto) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar el auto: "+auto);
        Optional<Auto> autoBuscado= autoService.buscarPorId(auto.getId());
        if(autoBuscado.isPresent()){
            logger.info("Se actualizo el auto: " + auto);
            autoService.actualizarAuto(auto);
            return ResponseEntity.ok("Auto: "+auto.getNombre()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo el auto: " + auto);
            throw new ResourceNotFoundException("No se pudo encontrar el auto con el id: "+auto.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Auto>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar un auto con el id: "+id);
        Optional<Auto> autoBuscado= autoService.buscarPorId(id);
        if(autoBuscado.isPresent()){
            logger.info("Se encontro el auto con el id: "+id);
            return ResponseEntity.ok(autoBuscado);
        }else{
            logger.info("No se encontro el auto con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar el auto con el id: "+id+".");
        }

    }
    @GetMapping("/buscar/{matricula}")
    public ResponseEntity<Optional<Auto>> buscarPorMatricula(@PathVariable String matricula) throws ResourceNotFoundException{
        logger.info("Llego la peticion de buscar un auto con la matricula: "+matricula);
        Optional<Auto> autoBuscado= autoService.buscarPorMatricula(matricula);
        if(autoBuscado.isPresent()){
            logger.info("Se encontro el auto con la matricula: "+matricula);
            return ResponseEntity.ok(autoBuscado);
        }else{
            logger.info("No se encontro el auto con la matricula: "+matricula);
            throw new ResourceNotFoundException("No se pudo encontrar el auto con la matricula: "+matricula+".");
        }
    }

    @GetMapping
    public ResponseEntity<List<Auto>> listarAutos() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todos los autos");
        List<Auto> listaAutos = autoService.listarAutos();
        if(listaAutos.size() > 0){
            logger.info("Existen autos");
            return ResponseEntity.ok(listaAutos);
        }else{
            logger.info("No existen autos");
            throw new ResourceNotFoundException("No hay ningun auto presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAuto(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar el auto con el id: "+id);
        Optional<Auto> autoBuscado = autoService.buscarPorId(id);
        if(autoBuscado.isPresent()){
            logger.info("Se elimino el auto con el id: "+id);
            autoService.eliminarAuto(id);
            return ResponseEntity.ok("Auto con el id: "+ id +" eliminado con exito.");
        }else
            logger.info("No se elimino el auto con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro auto a eliminar.");
    }
}
