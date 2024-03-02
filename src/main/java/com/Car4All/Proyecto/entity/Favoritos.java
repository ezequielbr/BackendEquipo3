package com.Car4All.Proyecto.entity;

import javax.annotation.processing.Generated;

import java.util.ArrayList;
import java.util.List;


public class Favoritos {

    private Long favoritosId;
    private Long usuarioId;
    private List<Auto> autos = new ArrayList<>();

    public Long getFavoritosId() {
        return favoritosId;
    }

    public void setFavoritosId(Long favoritosId) {
        this.favoritosId = favoritosId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public void anadirItem(Auto auto){
        this.autos.add(auto);
    }

    public void verDetalle(){
        System.out.println("Favoritos ID: " + favoritosId);
        System.out.println("Usuario ID: " + usuarioId);
        System.out.println("Autos Favoritos");
        for(Auto auto : autos){
            System.out.println("- "+ auto.getMarca());
        }
    }
}