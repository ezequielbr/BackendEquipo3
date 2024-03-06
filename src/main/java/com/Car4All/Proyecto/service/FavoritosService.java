package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Favoritos;
import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.repository.AutoRepository;
import com.Car4All.Proyecto.repository.FavoritosRepository;
import com.Car4All.Proyecto.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FavoritosService {
    private static final Logger logger=  LogManager.getLogger(FavoritosService.class);

    @Autowired
    private FavoritosRepository favoritosRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Optional<Favoritos> agregarAutoAlFavoritos(Long usuarioId, Long autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Optional<Auto> autoOptional = autoRepository.findById(autoId);

        if (usuarioOptional.isPresent() && autoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Auto auto = autoOptional.get();

            Favoritos favoritos = usuario.getFavoritos();
            favoritos.getAutos().add(auto);

            favoritosRepository.save(favoritos);

            return Optional.of(favoritos);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Favoritos> eliminarAutoDelFavoritos(Long usuarioId, Long autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Optional<Auto> autoOptional = autoRepository.findById(autoId);

        if (usuarioOptional.isPresent() && autoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Auto auto = autoOptional.get();

            Favoritos favoritos = usuario.getFavoritos();
            favoritos.getAutos().remove(auto);

            favoritosRepository.save(favoritos);

            return Optional.of(favoritos);
        } else {
            return Optional.empty();
        }
    }

    }
