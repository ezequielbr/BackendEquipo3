package com.Car4All.Proyecto.dto;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class AutoDTO {

    private Long id;
    @NonNull
    private String modelo;
    @NonNull
    private String marca;
    @NonNull
    private Integer personas;
    @NonNull
    private String tipoCaja;
    @NonNull
    private String imgUrl;
    @NonNull
    private Integer puertas;
    @NonNull
    private Integer valijas;
    @NonNull
    private Double precio;

    public AutoDTO(String modelo, String marca, Integer personas, String tipoCaja, Integer puertas, Integer valijas, Double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.personas = personas;
        this.tipoCaja = tipoCaja;
        this.puertas = puertas;
        this.valijas = valijas;
        this.precio = precio;
    }


}
