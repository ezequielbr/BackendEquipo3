package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.exception.BadRequestException;
import com.Car4All.Proyecto.repository.ReservaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservaService {
    private static final Logger logger=  LogManager.getLogger(ReservaService.class);

    @Autowired
    private ReservaRepository reservaRepository;


    public Reserva guardarReserva(Reserva reserva) throws BadRequestException {
        logger.info("Se esta llevando a cabo el proceso de Guardar Reserva");
        Auto auto = reserva.getAuto();
        Set<Reserva> reservas= auto.getReservas();
        for(Reserva reserva1 : reservas){
            if (reserva.getFechaInicio().isEqual(reserva1.getFechaInicio()) ||
                    reserva.getFechaFin().isEqual(reserva1.getFechaFin()) ||
                    (reserva.getFechaInicio().isBefore(reserva1.getFechaFin()) && reserva.getFechaFin().isAfter(reserva1.getFechaInicio()))) {
                throw new BadRequestException("No se puede realizar la reserva en fechas donde el auto se encuentra reservado");
            }
        }
        return reservaRepository.save(reserva);
    }
    public Reserva actualizarReserva(Reserva reserva){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Reserva");
        return reservaRepository.save(reserva);
    }
    public void eliminarReserva(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Reserva");
        reservaRepository.deleteById(id);
    }
    public Optional<Reserva> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Reserva por Id");
        return reservaRepository.findById(id);
    }
    public Optional<Reserva> buscarPorFechaInicio(LocalDate fechaInicio){
        logger.info("Se esta llevando a cabo el proceso de buscar Reserva por fechaInicio");
        return reservaRepository.findByFechaInicio(fechaInicio);
    }
    public Optional<Reserva> buscarPorFechaFin(LocalDate fechaFin){
        logger.info("Se esta llevando a cabo el proceso de buscar Reserva por fechaFin");
        return reservaRepository.findByFechaFin(fechaFin);
    }
    public List<Reserva> listarReservas(){
        logger.info("Se esta llevando a cabo el proceso de Listar Reservas");
        return reservaRepository.findAll();
    }

}
