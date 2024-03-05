package com.Car4All.Proyecto.service;


import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Carrito;

import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.repository.AutoRepository;
import com.Car4All.Proyecto.repository.CarritoRepository;
import com.Car4All.Proyecto.repository.ReservaRepository;
import com.Car4All.Proyecto.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    private static final Logger logger=  LogManager.getLogger(CarritoService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Optional<Carrito> agregarAutoAlCarrito(Long usuarioId, Long autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Optional<Auto> autoOptional = autoRepository.findById(autoId);

        if (usuarioOptional.isPresent() && autoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Auto auto = autoOptional.get();

            Carrito carrito = usuario.getCarrito();
            carrito.getAutos().add(auto);

            carritoRepository.save(carrito);

            return Optional.of(carrito);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrito> eliminarAutoDelCarrito(Long usuarioId, Long autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Optional<Auto> autoOptional = autoRepository.findById(autoId);

        if (usuarioOptional.isPresent() && autoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Auto auto = autoOptional.get();

            Carrito carrito = usuario.getCarrito();
            carrito.getAutos().remove(auto);

            carritoRepository.save(carrito);

            return Optional.of(carrito);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Reserva> crearReservaDesdeCarrito(Long usuarioId, Long autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Optional<Auto> autoOptional = autoRepository.findById(autoId);

        if (usuarioOptional.isPresent() && autoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Auto auto = autoOptional.get();

            Carrito carrito = usuario.getCarrito();
            if (carrito.getAutos().contains(auto)) {
                Reserva reserva = new Reserva();
                reserva.setUsuario(usuario);
                reserva.setAuto(auto);
                reservaRepository.save(reserva);
                carrito.getAutos().remove(auto);
                carritoRepository.save(carrito);

                return Optional.of(reserva);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }
}