package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Carrito;
import com.Car4All.Proyecto.repository.AutoRepository;
import com.Car4All.Proyecto.repository.CarritoRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;
    @Autowired
    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public Carrito agregarItemAlCarrito(Long carritoId, Long autoId, int cantidad) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        // A ajustar según características del auto
        ItemCarrito item = new ItemCarrito(autoId, "Descripción del auto", 10000.0, cantidad);
        carrito.añadirItem(item);

        return carritoRepository.save(carrito);
    }

    public List<ItemCarrito> verDetalleCarrito(Long carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return carrito.getItems();
    }

    public void realizarPedido(Long carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        carrito.setFechaAdicion(LocalDate.now());
        carritoRepository.save(carrito);
    }
}