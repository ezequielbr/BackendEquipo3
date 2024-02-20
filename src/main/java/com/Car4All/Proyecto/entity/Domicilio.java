package com.Car4All.Proyecto.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
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

}
