package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Carrito;
import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.service.CarritoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    private static final Logger logger= LogManager.getLogger(CarritoController.class);

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/agregar-auto")
    public ResponseEntity<String> agregarAutoAlCarrito(@RequestParam Long usuarioId, @RequestParam Long autoId) {
        logger.info("Llego la peticion de agregar un auto con el id: "+autoId+" al carrito.");
        Optional<Carrito> carritoOptional = carritoService.agregarAutoAlCarrito(usuarioId, autoId);
        return carritoOptional.map(carrito -> ResponseEntity.ok("Auto agregado al carrito"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }

    @DeleteMapping("/eliminar-auto")
    public ResponseEntity<String> eliminarAutoDelCarrito(@RequestParam Long usuarioId, @RequestParam Long autoId) {
        logger.info("Llego la peticion de eliminar un auto con el id: "+autoId+" al carrito.");
        Optional<Carrito> carritoOptional = carritoService.eliminarAutoDelCarrito(usuarioId, autoId);
        return carritoOptional.map(carrito -> ResponseEntity.ok("Auto eliminado del carrito"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o auto no encontrado"));
    }

    @PostMapping("/crear-reserva")
    public ResponseEntity<String> crearReservaDesdeCarrito(@RequestParam Long usuarioId, @RequestParam Long autoId) {
        logger.info("Llego la peticion de crear una reserva de el usuario con el id: "+usuarioId+" y el auto con el id: " +autoId+".");
        Optional<Reserva> reservaOptional = carritoService.crearReservaDesdeCarrito(usuarioId, autoId);
        return reservaOptional.map(reserva -> ResponseEntity.ok("Reserva creada exitosamente"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario, auto o carrito no encontrado"));
    }
}