package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Favoritos;
import com.Car4All.Proyecto.entity.Imagen;
import com.Car4All.Proyecto.entity.dto.AutoDTO;
import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.repository.AutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutoService {
    private static final Logger logger=  LogManager.getLogger(AutoService.class);

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private ImagenService imagenService;

    public Auto guardarAuto(AutoDTO autoDTO) throws ResourceNotFoundException {
        logger.info("Se está llevando a cabo el proceso de Guardar Auto");
        return actualizarImagenesAuto(autoDTO);
    }

    public Auto actualizarAuto(AutoDTO autoDTO) throws ResourceNotFoundException{
        logger.info("Se está llevando a cabo el proceso de Actualizar Auto");
        return actualizarImagenesAuto(autoDTO);
    }

    private Auto actualizarImagenesAuto(AutoDTO autoDTO) throws ResourceNotFoundException {
        Auto auto = mapper.convertValue(autoDTO, Auto.class);
        if (!autoDTO.getImagenes().isEmpty()) {
            for (Imagen imagen : autoDTO.getImagenes()) {
                Optional<Auto> autoOptional = agregarImagenUrlAlAuto(imagen.getUrlImg(), autoDTO.getId());
                if (autoOptional.isPresent()) {
                    auto.setImagenes(autoOptional.get().getImagenes());
                } else {
                    throw new ResourceNotFoundException("La imagen con el url: "+imagen.getUrlImg()+"no existe en la base de datos.");
                }
            }
        }
        return autoRepository.save(auto);
    }


    public void eliminarAuto(Integer id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Auto");
        autoRepository.deleteById(Long.valueOf(id));
    }
    public Optional<Auto> buscarPorId(Integer id){
        logger.info("Se esta llevando a cabo el proceso de buscar Auto por Id");
        return autoRepository.findById(Long.valueOf(id));
    }
    public List<Auto> listarAutos(){
        logger.info("Se esta llevando a cabo el proceso de Listar Autos");
        return autoRepository.findAll();
    }
    public Optional<Auto> agregarImagenAlAuto(Integer imagenId, Integer autoId) {
        Optional<Imagen> imagenOptional = imagenService.buscarPorId(Long.valueOf(imagenId));
        Optional<Auto> autoOptional = autoRepository.findById(Long.valueOf(autoId));

        if (imagenOptional.isPresent() && autoOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            Auto auto = autoOptional.get();

            imagen.setAuto(auto);
            imagenService.actualizarImagen(imagen);
            auto.getImagenes().add(imagen);
            autoRepository.save(auto);

            return Optional.of(auto);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Auto> agregarImagenUrlAlAuto(String url, Integer autoId) {
        Optional<Imagen> imagenOptional = imagenService.buscarPorUrl(url);
        Optional<Auto> autoOptional = autoRepository.findById(Long.valueOf(autoId));

        if (imagenOptional.isPresent() && autoOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            Auto auto = autoOptional.get();

            imagen.setAuto(auto);
            imagenService.actualizarImagen(imagen);
            auto.getImagenes().add(imagen);
            autoRepository.save(auto);

            return Optional.of(auto);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Auto> eliminarImagenUrlAlAuto(String url, Integer autoId) {
        Optional<Imagen> imagenOptional = imagenService.buscarPorUrl(url);
        Optional<Auto> autoOptional = autoRepository.findById(Long.valueOf(autoId));

        if (imagenOptional.isPresent() && autoOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            Auto auto = autoOptional.get();

            imagen.setAuto(null);
            imagenService.actualizarImagen(imagen);
            auto.getImagenes().remove(imagen);
            autoRepository.save(auto);

            return Optional.of(auto);
        } else {
            return Optional.empty();
        }
    }
}
