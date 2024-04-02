package com.Car4All.Proyecto.entity.dto;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Carrito;
import com.Car4All.Proyecto.entity.Categoria;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private String imgUrl;
    @NonNull
    private Integer puertas;
    @NonNull
    private Integer valijas;
    @NonNull
    private Double precio;

    private Categoria categoria;



}
