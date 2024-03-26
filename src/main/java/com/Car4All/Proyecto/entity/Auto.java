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
    @NonNull
    @Column
    private String matricula;
    @NonNull
    @Column
    private Boolean isReservado;
    @NonNull
    @Column
    private String ubicacion;

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
    private Set<Valoracion> valoraciones= new HashSet<>();
    @OneToMany
    @JoinColumn(name = "reservas_id",referencedColumnName = "id")
    private Set<Reserva> reservas= new HashSet<>();
}