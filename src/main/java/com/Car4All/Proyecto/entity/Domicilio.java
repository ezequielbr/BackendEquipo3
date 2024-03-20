package com.Car4All.Proyecto.entity;

import lombok.*;

import jakarta.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private String calle;
    @NonNull
    @Column
    private Integer numero;
    @NonNull
    @Column
    private String localidad;
    @NonNull
    @Column
    private String provincia;

    public Domicilio(@NonNull String calle, @NonNull Integer numero, @NonNull String localidad, @NonNull String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
