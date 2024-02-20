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
    private String matricula;
    @NonNull
    @Column
    private String nombre;
    @NonNull
    @Column
    private String apellido;
    @OneToMany(mappedBy ="auto", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reserva> resevas= new HashSet<>();
}
