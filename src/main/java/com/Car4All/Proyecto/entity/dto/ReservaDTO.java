package com.Car4All.Proyecto.entity.dto;

import java.time.LocalDate;

public class ReservaDTO {

    private Long reservaId;
    private Long usuarioId;
    private Long autoId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ReservaDTO() {
    }

    public ReservaDTO(Long reservaId, Long usuarioId, Long autoId, LocalDate fechaInicio, LocalDate fechaFin) {
        this.reservaId = reservaId;
        this.usuarioId = usuarioId;
        this.autoId = autoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "reservaId=" + reservaId +
                ", usuarioId=" + usuarioId +
                ", autoId=" + autoId +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}