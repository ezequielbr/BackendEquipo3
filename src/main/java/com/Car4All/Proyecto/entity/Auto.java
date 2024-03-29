package com.Car4All.Proyecto.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
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
    private Integer personas;
    @Column
    private String tipoCombustible;
    @NonNull
    @Column
    private String tipoCaja;
    @Column
    private String matricula;
    @Column
    private String imgUrl;
//    @NonNull
//    @Column
//    private Set<String> imagenes= new HashSet<>();
    @NonNull
    @Column
    private Integer puertas;
    @NonNull
    @Column
    private Integer valijas;
    @NonNull
    @Column
    private Double precio;


    @ManyToMany(mappedBy = "autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Carrito> carritos= new HashSet<>();
    @ManyToMany(mappedBy ="autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Categoria> categorias= new HashSet<>();
    @ManyToMany(mappedBy ="autos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Favoritos> favoritos= new HashSet<>();
    @OneToMany
    @JoinColumn(name = "valoracion_id",referencedColumnName = "id")
    @JsonIgnore
    private Set<Valoracion> valoraciones= new HashSet<>();
    @OneToMany
    @JoinColumn(name = "reservas_id",referencedColumnName = "id")
    @JsonIgnore
    private Set<Reserva> reservas= new HashSet<>();
    @OneToMany
    @JoinColumn(name = "imagenes_id",referencedColumnName = "id")
    @JsonIgnore
    private Set<Imagen> imagenes= new HashSet<>();
}