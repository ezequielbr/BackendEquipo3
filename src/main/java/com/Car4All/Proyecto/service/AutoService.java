package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.dto.AutoDTO;
import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.repository.AutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {
    private static final Logger logger=  LogManager.getLogger(AutoService.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private AutoRepository autoRepository;

    public Auto guardarAuto(AutoDTO auto){
        Auto auto1 = mapper.convertValue(auto, Auto.class );
        logger.info("Se esta llevando a cabo el proceso de Guardar Auto");
        return autoRepository.save(auto1);
    }
    public Auto actualizarAuto(AutoDTO auto){
        Auto auto1 = mapper.convertValue(auto, Auto.class );
        logger.info("Se esta llevando a cabo el proceso de Actualizar Auto");
        return autoRepository.save(auto1);
    }
    public void eliminarAuto(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Auto");
        autoRepository.deleteById(id);
    }
    public Optional<Auto> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Auto por Id");
        return autoRepository.findById(id);
    }
    public List<Auto> listarAutos(){
        logger.info("Se esta llevando a cabo el proceso de Listar Autos");
        return autoRepository.findAll();
    }
}
