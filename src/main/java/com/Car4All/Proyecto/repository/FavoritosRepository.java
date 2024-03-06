package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoritosRepository  extends JpaRepository<Favoritos, Long> {

}