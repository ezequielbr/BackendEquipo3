package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.entity.Reserva;
import com.Car4All.Proyecto.service.ReservaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private static final Logger logger= LogManager.getLogger(AutoController.class);
    @Autowired
    private ReservaService reservaService= new ReservaService();
    @PostMapping
    public ResponseEntity<Reserva> registrarReserva(@RequestBody Reserva reserva){
        logger.info("Llego la peticion de registrar la reserva: "+reserva);
        return ResponseEntity.ok(reservaService.guardarReserva(reserva));
    }
    @PutMapping
    public ResponseEntity<String> actualizarReserva(@RequestBody Reserva reserva) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar la reserva: "+reserva);
        Optional<Reserva> reservaBuscada= reservaService.buscarPorId(reserva.getId());
        if(reservaBuscada.isPresent()){
            logger.info("Se actualizo la reserva: " + reserva);
            reservaService.actualizarReserva(reserva);
            return ResponseEntity.ok("Reserva con el id: "+reserva.getId()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo la reserva: " + reserva);
            throw new ResourceNotFoundException("No se pudo encontrar la reserva con la id: "+reserva.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Reserva>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar un reserva con la id: "+id);
        Optional<Reserva> reservaBuscada= reservaService.buscarPorId(id);
        if(reservaBuscada.isPresent()){
            logger.info("Se encontro la reserva con la id: "+id);
            return ResponseEntity.ok(reservaBuscada);
        }else{
            logger.info("No se encontro la reserva con la id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar la reserva con la id: "+id+".");
        }

    }
    @GetMapping("/buscar/{fechaInicio}")
    public ResponseEntity<Optional<Reserva>> buscarPorFechaInicio(@PathVariable LocalDate fechaInicio) throws ResourceNotFoundException{
        logger.info("Llego la peticion de buscar un reserva con la fechaInicio: "+fechaInicio);
        Optional<Reserva> reservaBuscada= reservaService.buscarPorFechaInicio(fechaInicio);
        if(reservaBuscada.isPresent()){
            logger.info("Se encontro la reserva con la fechaInicio: "+fechaInicio);
            return ResponseEntity.ok(reservaBuscada);
        }else{
            logger.info("No se encontro la reserva con la fechaInicio: "+fechaInicio);
            throw new ResourceNotFoundException("No se pudo encontrar la reserva con la fechaInicio: "+fechaInicio+".");
        }
    }
    @GetMapping("/buscar/{fechaFin}")
    public ResponseEntity<Optional<Reserva>> buscarPorFechaFin(@PathVariable LocalDate fechaFin) throws ResourceNotFoundException{
        logger.info("Llego la peticion de buscar un reserva con la fechaFin: "+fechaFin);
        Optional<Reserva> reservaBuscada= reservaService.buscarPorFechaFin(fechaFin);
        if(reservaBuscada.isPresent()){
            logger.info("Se encontro la reserva con la fechaFin: "+fechaFin);
            return ResponseEntity.ok(reservaBuscada);
        }else{
            logger.info("No se encontro la reserva con la fechaFin: "+fechaFin);
            throw new ResourceNotFoundException("No se pudo encontrar la reserva con la fechaFin: "+fechaFin+".");
        }
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todos los reservas");
        List<Reserva> listaReservas = reservaService.listarReservas();
        if(listaReservas.size() > 0){
            logger.info("Existen reservas");
            return ResponseEntity.ok(listaReservas);
        }else{
            logger.info("No existen reservas");
            throw new ResourceNotFoundException("No hay ningun reserva presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar la reserva con la id: "+id);
        Optional<Reserva> reservaBuscada = reservaService.buscarPorId(id);
        if(reservaBuscada.isPresent()){
            logger.info("Se elimino la reserva con la id: "+id);
            reservaService.eliminarReserva(id);
            return ResponseEntity.ok("Reserva con la id: "+ id +" eliminado con exito.");
        }else
            logger.info("No se elimino la reserva con la id: "+id);
        throw  new ResourceNotFoundException("No se encontro reserva a eliminar.");
    }
}
