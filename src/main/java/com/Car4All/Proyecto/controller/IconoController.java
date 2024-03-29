package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Icono;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.IconoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/icono")
public class IconoController {
    private static final Logger logger= LogManager.getLogger(IconoController.class);

    @Autowired
    private IconoService iconoService;
    @PostMapping
    public ResponseEntity<Icono> registrarIcono(@RequestBody Icono icono){
        logger.info("Llego la peticion de registrar el icono: "+icono.getNombre());
        return ResponseEntity.ok(iconoService.guardarIcono(icono));
    }
    @PutMapping
    public ResponseEntity<String> actualizarIcono(@RequestBody Icono icono) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar el icono: "+icono);
        Optional<Icono> iconoBuscado= iconoService.buscarPorId(icono.getId());
        if(iconoBuscado.isPresent()){
            logger.info("Se actualizo el icono: " + icono.getNombre());
            iconoService.actualizarIcono(icono);
            return ResponseEntity.ok("Icono con el id: "+icono.getId()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo el icono: " + icono.getNombre());
            throw new ResourceNotFoundException("No se pudo encontrar el icono con el id: "+icono.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Icono>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar una icono con el id: "+id);
        Optional<Icono> iconoBuscado= iconoService.buscarPorId(id);
        if(iconoBuscado.isPresent()){
            logger.info("Se encontro la icono con el id: "+id);
            return ResponseEntity.ok(iconoBuscado);
        }else{
            logger.info("No se encontro el icono con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar el icono con el id: "+id+".");
        }

    }

    @GetMapping
    public ResponseEntity<List<Icono>> listarIconos() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todas los iconoes");
        List<Icono> listaIconos = iconoService.listarIconos();
        if(!listaIconos.isEmpty()){
            logger.info("Existen iconos");
            return ResponseEntity.ok(listaIconos);
        }else{
            logger.info("No existen iconos");
            throw new ResourceNotFoundException("No hay ningun icono presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarIcono(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar el icono con el id: "+id);
        Optional<Icono> iconoBuscado = iconoService.buscarPorId(id);
        if(iconoBuscado.isPresent()){
            logger.info("Se elimino el icono con el id: "+id);
            iconoService.eliminarIcono(id);
            return ResponseEntity.ok("Icono con el id: "+ id +" eliminada con exito.");
        }else
            logger.info("No se elimino el icono con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro icono a eliminar.");
    }
}
