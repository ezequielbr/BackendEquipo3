package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.repository.AutoRepository;
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
    private AutoRepository autoRepository;

    public Auto guardarAuto(Auto auto){
        logger.info("Se esta llevando a cabo el proceso de Guardar Auto");
        return autoRepository.save(auto);
    }
    public Auto actualizarAuto(Auto auto){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Auto");
        return autoRepository.save(auto);
    }
    public void eliminarAuto(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Auto");
        autoRepository.deleteById(id);
    }
    public Optional<Auto> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Auto por Id");
        return autoRepository.findById(id);
    }
    public Optional<Auto> buscarPorMatricula(String matricula){
        logger.info("Se esta llevando a cabo el proceso de buscar Auto por matricula");
        return autoRepository.findByMatricula(matricula);
    }
    public List<Auto> listarAutos(){
        logger.info("Se esta llevando a cabo el proceso de Listar Autos");
        return autoRepository.findAll();
    }
}
