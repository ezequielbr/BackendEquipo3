package com.Car4All.Proyecto.entity.dto;

import java.util.Arrays;

public class FavoritosDTO {

    private Long favoritosId;
    private Long usuarioId;
    private String[] autos;

    public FavoritosDTO() {
    }

    public FavoritosDTO(Long favoritosId, Long usuarioId, String[] autos) {
        this.favoritosId = favoritosId;
        this.usuarioId = usuarioId;
        this.autos = autos;
    }

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

    public String[] getAutos() {
        return autos;
    }

    public void setAutos(String[] autos) {
        this.autos = autos;
    }

    public void anadirItem(String nuevoAuto){
        String[] nuevaLista = Arrays.copyOf(autos, autos.length+1);
        nuevaLista[nuevaLista.length-1]=nuevoAuto;
        autos=nuevaLista;

    }
    public void verDetalle(){
        System.out.println("Favoritos ID: " + favoritosId);
        System.out.println("Usuario ID: " + usuarioId);
        System.out.println("Autos favoritos");
        for (String auto : autos){
            System.out.println("- " + auto);
        }
    }

    @Override
    public String toString() {
        return "FavoritosDTO{" +
                "favoritosId=" + favoritosId +
                ", usuarioId=" + usuarioId +
                ", autos=" + Arrays.toString(autos) +
                '}';
    }
}
