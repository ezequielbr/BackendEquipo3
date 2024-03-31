package com.Car4All.Proyecto.repository;

import com.Car4All.Proyecto.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Long> {
}