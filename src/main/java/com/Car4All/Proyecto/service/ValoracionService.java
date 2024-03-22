package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Valoracion;
import com.Car4All.Proyecto.repository.ValoracionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ValoracionService {
    private static final Logger logger=  LogManager.getLogger(ValoracionService.class);

    @Autowired
    private ValoracionRepository valoracionRepository;

    public Valoracion guardarValoracion(Valoracion valoracion){
        logger.info("Se esta llevando a cabo el proceso de Guardar Valoracion");
        return valoracionRepository.save(valoracion);
    }
    public Valoracion actualizarValoracion(Valoracion valoracion){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Valoracion");
        return valoracionRepository.save(valoracion);
    }
    public void eliminarValoracion(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Valoracion");
        valoracionRepository.deleteById(id);
    }
    public Optional<Valoracion> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Valoracion por Id");
        return valoracionRepository.findById(id);
    }
    public List<Valoracion> listarValoracions(){
        logger.info("Se esta llevando a cabo el proceso de Listar Valoracions");
        return valoracionRepository.findAll();
    }
}
