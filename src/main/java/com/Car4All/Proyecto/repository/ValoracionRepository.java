package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion,Long> {
}
