package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Icono;
import com.Car4All.Proyecto.repository.IconoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconoService {
    private static final Logger logger=  LogManager.getLogger(IconoService.class);

    @Autowired
    private IconoRepository iconoRepository;
    public Icono guardarIcono(Icono icono){
        logger.info("Se esta llevando a cabo el proceso de Guardar Icono");

        return iconoRepository.save(icono);
    }
    public Icono actualizarIcono(Icono icono){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Icono");
        return iconoRepository.save(icono);
    }
    public void eliminarIcono(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Icono");
        iconoRepository.deleteById(id);
    }
    public Optional<Icono> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Icono por Id");
        return iconoRepository.findById(id);
    }
    public List<Icono> listarIconos(){
        logger.info("Se esta llevando a cabo el proceso de Listar Iconos");
        return iconoRepository.findAll();
    }
}
