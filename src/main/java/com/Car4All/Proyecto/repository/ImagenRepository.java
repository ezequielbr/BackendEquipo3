package com.Car4All.Proyecto.repository;


import com.Car4All.Proyecto.entity.Imagen;
import com.Car4All.Proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
    Optional<Imagen> findByUrlImg(String url);
}
