package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Favoritos;
import com.Car4All.Proyecto.service.FavoritosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/favoritos")
public class FavoritosController {
    private static final Logger logger= LogManager.getLogger(FavoritosController.class);

    @Autowired
    private FavoritosService favoritosService;

    @PostMapping("/agregar-auto")
    public ResponseEntity<String> agregarAutoAlFavoritos(@RequestParam Long usuarioId, @RequestParam Long autoId) {
        logger.info("Llego la peticion de agregar un auto con el id: "+autoId+" a favoritos.");
        Optional<Favoritos> favoritosOptional = favoritosService.agregarAutoAlFavoritos(usuarioId, autoId);
        return favoritosOptional.map(favoritos -> ResponseEntity.ok("Auto agregado a favoritos"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }

    @DeleteMapping("/eliminar-auto")
    public ResponseEntity<String> eliminarAutoDelFavoritos(@RequestParam Long usuarioId, @RequestParam Long autoId) {
        logger.info("Llego la peticion de eliminar un auto con el id: "+autoId+" a favoritos.");
        Optional<Favoritos> favoritosOptional = favoritosService.eliminarAutoDelFavoritos(usuarioId, autoId);
        return favoritosOptional.map(favoritos -> ResponseEntity.ok("Auto eliminado del favoritos"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }
}
