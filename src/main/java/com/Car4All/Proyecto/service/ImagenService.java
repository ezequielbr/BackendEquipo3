package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Imagen;
import com.Car4All.Proyecto.repository.ImagenRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImagenService {
    private static final Logger logger=  LogManager.getLogger(ImagenService.class);

    @Autowired
    private ImagenRepository imagenRepository;
    public Imagen guardarImagen(Imagen imagen){
        logger.info("Se esta llevando a cabo el proceso de Guardar Imagen");

        return imagenRepository.save(imagen);
    }
    public Imagen actualizarImagen(Imagen imagen){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Imagen");
        return imagenRepository.save(imagen);
    }
    public void eliminarImagen(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Imagen");
        imagenRepository.deleteById(id);
    }
    public Optional<Imagen> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Imagen por Id");
        return imagenRepository.findById(id);
    }
    public List<Imagen> listarImagenes(){
        logger.info("Se esta llevando a cabo el proceso de Listar Imagenes");
        return imagenRepository.findAll();
    }
   
}
