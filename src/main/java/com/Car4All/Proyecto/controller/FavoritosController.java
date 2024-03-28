package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Favoritos;
import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.request.CategoriaAutoRequest;
import com.Car4All.Proyecto.request.UsuarioAutoRequest;
import com.Car4All.Proyecto.service.FavoritosService;
import com.Car4All.Proyecto.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/favoritos")
public class FavoritosController {
    private static final Logger logger= LogManager.getLogger(FavoritosController.class);

    @Autowired
    private FavoritosService favoritosService;


    @GetMapping("/usuario/{id}")
    public ResponseEntity<Set<Auto>> listarAutosFavoritos(@PathVariable Integer id) {
        logger.info("Llego la petición de listar todos los favoritos");
        Set<Auto> autos = favoritosService.listarAutosFavoritos(id);
        if (!autos.isEmpty()) {
            logger.info("Existen favoritos");
            return ResponseEntity.ok(autos);
        } else {
            logger.info("No existen favoritos");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashSet<>());
        }
    }

    @PostMapping("/agregar-auto")
    public ResponseEntity<String> agregarAutoAlFavoritos(@RequestBody UsuarioAutoRequest request) {
        logger.info("Llego la peticion de agregar un auto con el id: "+request.getAutoId()+" a favoritos.");
        Optional<Favoritos> favoritosOptional = favoritosService.agregarAutoAlFavoritos(request.getUsuarioId(), request.getAutoId());
        return favoritosOptional.map(favoritos -> ResponseEntity.ok("Auto agregado a favoritos"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }

    @DeleteMapping("/eliminar-auto")
    public ResponseEntity<String> eliminarAutoDelFavoritos(@RequestBody UsuarioAutoRequest request) {
        logger.info("Llego la peticion de eliminar un auto con el id: "+request.getAutoId()+" a favoritos.");
        Optional<Favoritos> favoritosOptional = favoritosService.eliminarAutoDelFavoritos(request.getUsuarioId(), request.getAutoId());
        return favoritosOptional.map(favoritos -> ResponseEntity.ok("Auto eliminado del favoritos"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }
}
