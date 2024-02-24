package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.repository.ReservaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private static final Logger logger=  LogManager.getLogger(ReservaService.class);

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva guardarReserva(Reserva auto){
        logger.info("Se esta llevando a cabo el proceso de Guardar Reserva");
        return reservaRepository.save(auto);
    }
    public Reserva actualizarAuto(Reserva auto){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Reserva");
        return reservaRepository.save(auto);
    }
    public void eliminarReserva(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Reserva");
        reservaRepository.deleteById(id);
    }
    public Optional<Reserva> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Reserva por Id");
        return reservaRepository.findById(id);
    }
    public Optional<Reserva> buscarPorFecha(LocalDate fecha){
        logger.info("Se esta llevando a cabo el proceso de buscar Reserva por fecha");
        return reservaRepository.findByFecha(fecha);
    }
    public List<Reserva> listarReservas(){
        logger.info("Se esta llevando a cabo el proceso de Listar Reservas");
        return reservaRepository.findAll();
    }
}
