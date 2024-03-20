package com.Car4All.Proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="valoraciones")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private Integer puntaje;
    @NonNull
    @Column
    private String comentario;
    @NonNull
    @ManyToOne
    @JoinColumn(name ="usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @NonNull
    @ManyToOne
    @JoinColumn(name ="auto_id", referencedColumnName = "id")
    private Auto auto;
}
