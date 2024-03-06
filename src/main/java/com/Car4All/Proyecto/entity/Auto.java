package com.Car4All.Proyecto.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private String modelo;
    @NonNull
    @Column
    private String marca;
    @NonNull
    @Column
    private Integer cantidadDePlazas;
    @NonNull
    @Column
    private String tipoCombustible;
    @NonNull
    @Column
    private String tipoCaja;
    @NonNull
    @Column
    private String tipoVehiculo;
    @NonNull
    @Column
    private String region;
    @NonNull
    @Column
    private Boolean recomendado;

    @ManyToMany(mappedBy = "autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Carrito> carritos= new HashSet<>();

    @ManyToMany(mappedBy ="autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Categoria> categorias= new HashSet<>();

    @ManyToMany(mappedBy ="autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Favoritos> favoritos= new HashSet<>();

}