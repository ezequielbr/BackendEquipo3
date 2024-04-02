package com.Car4All.Proyecto.entity.dto;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long id;
    @NonNull
    private Long usuarioId;
    @NonNull
    private Long autoId;
    @NonNull
    private LocalDate fechaInicio;
    @NonNull
    private LocalDate fechaFin;


}