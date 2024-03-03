package com.Car4All.Proyecto.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
