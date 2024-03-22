package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Valoracion;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.ValoracionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/valoraciones")
public class ValoracionController {
    private static final Logger logger= LogManager.getLogger(ValoracionController.class);
    @Autowired
    private ValoracionService valoracionService= new ValoracionService();
    @PostMapping
    public ResponseEntity<Valoracion> registrarValoracion(@RequestBody Valoracion valoracion){
        logger.info("Llego la peticion de registrar la valoracion: "+valoracion);
        return ResponseEntity.ok(valoracionService.guardarValoracion(valoracion));
    }
    @PutMapping
    public ResponseEntity<String> actualizarValoracion(@RequestBody Valoracion valoracion) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar la valoracion: "+valoracion);
        Optional<Valoracion> valoracionBuscada= valoracionService.buscarPorId(valoracion.getId());
        if(valoracionBuscada.isPresent()){
            logger.info("Se actualizo la valoracion: " + valoracion);
            valoracionService.actualizarValoracion(valoracion);
            return ResponseEntity.ok("Valoracion con el id: "+valoracion.getId()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo la valoracion: " + valoracion);
            throw new ResourceNotFoundException("No se pudo encontrar la valoracion con el id: "+valoracion.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Valoracion>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar un valoracion con el id: "+id);
        Optional<Valoracion> valoracionBuscada= valoracionService.buscarPorId(id);
        if(valoracionBuscada.isPresent()){
            logger.info("Se encontro la valoracion con el id: "+id);
            return ResponseEntity.ok(valoracionBuscada);
        }else{
            logger.info("No se encontro la valoracion con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar la valoracion con el id: "+id+".");
        }

    }
    @GetMapping
    public ResponseEntity<List<Valoracion>> listarValoracions() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todos los valoracions");
        List<Valoracion> listaValoracions = valoracionService.listarValoracions();
        if(listaValoracions.size() > 0){
            logger.info("Existen valoracions");
            return ResponseEntity.ok(listaValoracions);
        }else{
            logger.info("No existen valoracions");
            throw new ResourceNotFoundException("No hay ninguna valoracion presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarValoracion(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar la valoracion con el id: "+id);
        Optional<Valoracion> valoracionBuscada = valoracionService.buscarPorId(id);
        if(valoracionBuscada.isPresent()){
            logger.info("Se elimino la valoracion con el id: "+id);
            valoracionService.eliminarValoracion(id);
            return ResponseEntity.ok("Valoracion con el id: "+ id +" eliminado con exito.");
        }else
            logger.info("No se elimino la valoracion con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro la valoracion a eliminar.");
    }
}
