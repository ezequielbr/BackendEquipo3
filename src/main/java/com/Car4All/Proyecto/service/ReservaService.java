package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.entity.dto.ReservaDTO;
import com.Car4All.Proyecto.exception.BadRequestException;
import com.Car4All.Proyecto.repository.ReservaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private ObjectMapper mapper;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private AutoService autoService;
    public Reserva guardarReserva(ReservaDTO reserva) throws BadRequestException {
        logger.info("Se esta llevando a cabo el proceso de Guardar Reserva");
        Reserva reserva1 = mapper.convertValue(reserva, Reserva.class);
        Optional<Auto> auto = autoService.buscarPorId(reserva.getAutoId());
        Set<Reserva> reservas= auto.get().getReservas();
        for(Reserva reserva2 : reservas){
            if (reserva.getFechaInicio().isEqual(reserva2.getFechaInicio()) ||
                    reserva.getFechaFin().isEqual(reserva2.getFechaFin()) ||
                    (reserva.getFechaInicio().isBefore(reserva2.getFechaFin()) && reserva.getFechaFin().isAfter(reserva2.getFechaInicio()))) {
                throw new BadRequestException("No se puede realizar la reserva en fechas donde el auto se encuentra reservado");
            }
        }
        return reservaRepository.save(reserva1);
    }
    public Reserva actualizarReserva(ReservaDTO reserva){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Reserva");
        Reserva reserva1 = mapper.convertValue(reserva, Reserva.class);
        return reservaRepository.save(reserva1);
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
