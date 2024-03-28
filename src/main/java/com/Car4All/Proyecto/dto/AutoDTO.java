package com.Car4All.Proyecto.dto;

public class AutoDTO {
    private String modelo;
    private Long id;
    private String marca;
    private Integer personas;
    private String tipoCaja;
    private String imgUrl;
    private Integer puertas;
    private Integer valijas;
    private Double precio;

    public AutoDTO(String modelo, String marca, Integer personas, String tipoCaja, String imgUrl, Integer puertas, Integer valijas, Double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.personas = personas;
        this.tipoCaja = tipoCaja;
        this.imgUrl = imgUrl;
        this.puertas = puertas;
        this.valijas = valijas;
        this.precio = precio;
    }

    public AutoDTO() {
    }

    public AutoDTO(String modelo, String marca, Integer personas, String tipoCaja, Integer puertas, Integer valijas, Double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.personas = personas;
        this.tipoCaja = tipoCaja;
        this.puertas = puertas;
        this.valijas = valijas;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    public Integer getValijas() {
        return valijas;
    }

    public void setValijas(Integer valijas) {
        this.valijas = valijas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
