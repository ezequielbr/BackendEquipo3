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

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FavoritosService {
    private static final Logger logger=  LogManager.getLogger(FavoritosService.class);

    @Autowired
    private FavoritosRepository favoritosRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Optional<Favoritos> agregarAutoAlFavoritos(Integer usuarioId, Integer autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(Long.valueOf(usuarioId));
        Optional<Auto> autoOptional = autoRepository.findById(Long.valueOf(autoId));

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

    public Optional<Favoritos> eliminarAutoDelFavoritos(Integer usuarioId, Integer autoId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(Long.valueOf(usuarioId));
        Optional<Auto> autoOptional = autoRepository.findById(Long.valueOf(autoId));

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

    public Set<Auto> listarAutosFavoritos(Integer id) {
        logger.info("Se esta llevando a cabo el proceso de listar los autos Favoritos");
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id.longValue());
        Set<Auto> autos = usuarioOptional.get().getFavoritos().getAutos();
        return autos;
    }
}
