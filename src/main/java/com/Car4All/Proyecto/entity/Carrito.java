package com.Car4All.Proyecto.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Carrito {
    private Long carritoId;
    private Long autoId;
    private LocalDate fechaAdicion;
    private List<ItemCarrito> items = new ArrayList<>();


    public void añadirItem(ItemCarrito item) {
        items.add(item);
    }

    public void verDetalle() {
        for (ItemCarrito item : items) {
            System.out.println(item);
        }
    }

    public void confirmarReserva() {
        System.out.println("Reserva confirmada con éxito.");
    }
}