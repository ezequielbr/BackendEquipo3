package com.Car4All.Proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NonNull
    private String urlImg;
    @ManyToOne
    @JoinColumn(name ="auto_id", referencedColumnName = "id")
    private Auto auto;
}
