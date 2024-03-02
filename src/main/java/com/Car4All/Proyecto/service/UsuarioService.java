package com.Car4All.Proyecto.service;

import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService  implements UserDetailsService {
    private static final Logger logger=  LogManager.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario){
        logger.info("Se esta llevando a cabo el proceso de Guardar Usuario");
        return usuarioRepository.save(usuario);
    }
    public Usuario actualizarUsuario(Usuario usuario){
        logger.info("Se esta llevando a cabo el proceso de Actualizar Usuario");
        return usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Long id){
        logger.info("Se esta llevando a cabo el proceso de Eliminar Usuario");
        usuarioRepository.deleteById(id);
    }
    public Optional<Usuario> buscarPorId(Long id){
        logger.info("Se esta llevando a cabo el proceso de buscar Usuario por Id");
        return usuarioRepository.findById(id);
    }
    public List<Usuario> listarUsuarios(){
        logger.info("Se esta llevando a cabo el proceso de Listar Usuarios");
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> buscarPorEmail(String email){
        logger.info("Se esta llevando a cabo el proceso de buscar Usuario por Email");
        return usuarioRepository.findByEmail(email);
    }
    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario){
        logger.info("Se esta llevando a cabo el proceso de buscar Usuario por Email");
        return usuarioRepository.findByUserName(nombreUsuario);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return usuarioRepository.findByUserName(userName).get();
    }
}
