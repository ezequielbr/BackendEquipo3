package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.repository.AutoRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Long guardar(Categoria categoria);
    List<Categoria> mostrarTodos() throws ResourceNotFoundException;
    Categoria buscarPorId(Long id) throws ResourceNotFoundException;
    void modificar(Categoria categoria) ;
    void eliminar(Long id) throws ResourceNotFoundException;
}

