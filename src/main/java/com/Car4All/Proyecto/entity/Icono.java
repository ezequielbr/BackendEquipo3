package com.Car4All.Proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="iconos")
public class Icono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NonNull
    private String nombre;
    @Column
    @NonNull
    private String urlIcono;
    @ManyToOne
    @JoinColumn(name ="auto_id", referencedColumnName = "id")
    private Auto auto;
}
