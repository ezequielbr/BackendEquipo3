package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.PersonaReserva;
import com.Car4All.Proyecto.repository.PersonaReservaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaReservaService {
    private static final Logger logger=  LogManager.getLogger(PersonaReservaService.class);

    @Autowired 
    private PersonaReservaRepository personaRepository;

    public PersonaReserva guardarPersonaReserva(PersonaReserva persona){
        logger.info("Se esta llevando a cabo el proceso de Guardar PersonaReserva");
        return personaRepository.save(persona);
    }
    public PersonaReserva actualizarPersonaReserva(PersonaReserva persona){
        logger.info("Se esta llevando a cabo el proceso de Actualizar PersonaReserva");
        return personaRepository.save(persona);
    }
    public void eliminarPersonaReserva(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar PersonaReserva");
        personaRepository.deleteById(id);
    }
    public Optional<PersonaReserva> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar PersonaReserva por Id");
        return personaRepository.findById(id);
    }
    public Optional<PersonaReserva> buscarPorMatricula(Integer dni){
        logger.info("Se esta llevando a cabo el proceso de buscar PersonaReserva por matricula");
        return personaRepository.findByDni(dni);
    }
    public List<PersonaReserva> listarPersonaReservas(){
        logger.info("Se esta llevando a cabo el proceso de Listar PersonaReservas");
        return personaRepository.findAll();
    }
}
