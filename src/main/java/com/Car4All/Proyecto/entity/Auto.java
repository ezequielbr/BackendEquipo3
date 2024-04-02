package com.Car4All.Proyecto.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @NonNull
    @Column
    private String tipoCaja;
    @Column
    @NonNull
    private String imgUrl;
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
    @ManyToOne
    @JoinColumn(name ="categoria_id", referencedColumnName = "id")
    private Categoria categoria;
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
    @OneToMany
    @JoinColumn(name = "iconos_id",referencedColumnName = "id")
    @JsonIgnore
    private Set<Icono> iconos= new HashSet<>();
}