package com.Car4All.Proyecto.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Categorias")

public class Categoria {
    private Long categoriaId;
    private String nombre;
    private List<Auto> autos = new ArrayList<>();

    // Nuestro método para añadir autos
    public void agregarAuto(Auto auto) {
        this.autos.add(auto);
    }
}