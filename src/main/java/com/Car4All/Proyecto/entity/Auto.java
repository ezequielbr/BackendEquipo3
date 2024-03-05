package com.Car4All.Proyecto.entity;


import jakarta.persistence.*;
import lombok.*;



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
    @ManyToOne
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private Carrito carrito;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

}