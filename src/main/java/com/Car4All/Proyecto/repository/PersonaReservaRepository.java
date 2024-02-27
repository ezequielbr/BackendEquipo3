package com.Car4All.Proyecto.repository;


import com.Car4All.Proyecto.entity.PersonaReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaReservaRepository extends JpaRepository<PersonaReserva, Long> {
    Optional<PersonaReserva> findByDni(Integer dni);

}
