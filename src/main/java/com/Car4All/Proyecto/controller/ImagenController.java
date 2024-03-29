package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Imagen;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.ImagenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/imagen")
public class ImagenController {
    private static final Logger logger= LogManager.getLogger(ImagenController.class);

    @Autowired
    private ImagenService imagenService;
    @PostMapping
    public ResponseEntity<Imagen> registrarImagen(@RequestBody Imagen imagen){
        logger.info("Llego la peticion de registrar la imagen con el id: "+imagen.getId());
        return ResponseEntity.ok(imagenService.guardarImagen(imagen));
    }
    @PutMapping
    public ResponseEntity<String> actualizarImagen(@RequestBody Imagen imagen) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar el imagen: "+imagen);
        Optional<Imagen> imagenBuscado= imagenService.buscarPorId(imagen.getId());
        if(imagenBuscado.isPresent()){
            logger.info("Se actualizo el imagen con el id: " + imagen.getId());
            imagenService.actualizarImagen(imagen);
            return ResponseEntity.ok("Imagen con el id: "+imagen.getId()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo el imagen con el id: " + imagen.getId());
            throw new ResourceNotFoundException("No se pudo encontrar el imagen con el id: "+imagen.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Imagen>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar una imagen con el id: "+id);
        Optional<Imagen> imagenBuscado= imagenService.buscarPorId(id);
        if(imagenBuscado.isPresent()){
            logger.info("Se encontro la imagen con el id: "+id);
            return ResponseEntity.ok(imagenBuscado);
        }else{
            logger.info("No se encontro el imagen con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar el imagen con el id: "+id+".");
        }
    }
    @GetMapping
    public ResponseEntity<List<Imagen>> listarImagenes() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todas los imagenes");
        List<Imagen> listaImagens = imagenService.listarImagenes();
        if(!listaImagens.isEmpty()){
            logger.info("Existen imagenes");
            return ResponseEntity.ok(listaImagens);
        }else{
            logger.info("No existen imagenes");
            throw new ResourceNotFoundException("No hay ninguna imagen presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar la imagen con el id: "+id);
        Optional<Imagen> imagenBuscado = imagenService.buscarPorId(id);
        if(imagenBuscado.isPresent()){
            logger.info("Se elimino la imagen con el id: "+id);
            imagenService.eliminarImagen(id);
            return ResponseEntity.ok("Imagen con el id: "+ id +" eliminada con exito.");
        }else
            logger.info("No se elimino el imagen con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro imagen a eliminar.");
    }
}
