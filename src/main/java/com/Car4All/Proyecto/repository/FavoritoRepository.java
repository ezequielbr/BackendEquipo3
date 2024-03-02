package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FavoritosRepository  extends JpaRepository<Favoritos, Long> {

    Optional<Favoritos> findByFavoritosId(Long favoritosId);
}