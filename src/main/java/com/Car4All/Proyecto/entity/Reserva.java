package com.Car4All.Proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @OneToOne
    @JoinColumn(name ="usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @NonNull
    @OneToOne
    @JoinColumn(name ="auto_id", referencedColumnName = "id")
    private Auto auto;
    @NonNull
    @Column
    private LocalDate fechaInicio;
    @NonNull
    @Column
    private LocalDate fechaFin;
}
