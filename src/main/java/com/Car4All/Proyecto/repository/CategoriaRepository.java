package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNombre(String nombre);
}