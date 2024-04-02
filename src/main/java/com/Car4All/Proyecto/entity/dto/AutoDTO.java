package com.Car4All.Proyecto.entity.dto;

import com.Car4All.Proyecto.entity.*;
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

    private Integer id;
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
    private Set<Imagen> imagenes= new HashSet<>();
    private Set<Icono> iconos= new HashSet<>();



}
