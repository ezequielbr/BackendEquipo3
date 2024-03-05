package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Long> {

}