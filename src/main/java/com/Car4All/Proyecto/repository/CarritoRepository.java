package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Long> {

}