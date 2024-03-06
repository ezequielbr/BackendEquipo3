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
@Table(name="categorias")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private String nombre;
    @ManyToMany
    @JoinTable(name = "categoria_autos",joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "auto_id"))
    private Set<Auto> autos= new HashSet<>();

}