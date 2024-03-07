package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private static final Logger logger= LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
        logger.info("Llego la peticion de registrar el usuario: "+usuario);
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }
    @PutMapping
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar el usuario: "+usuario);
        Optional<Usuario> usuarioBuscado= usuarioService.buscarPorId(usuario.getId());
        if(usuarioBuscado.isPresent()){
            logger.info("Se actualizo el usuario: " + usuario);
            usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok("Usuario: "+usuario.getNombre()+" actualizado con exito.");
        }else{
            logger.info("No se actualizo el usuario: " + usuario);
            throw new ResourceNotFoundException("No se pudo encontrar el usuario con el id: "+usuario.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Usuario>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar un usuario con el id: "+id);
        Optional<Usuario> usuarioBuscado= usuarioService.buscarPorId(id);
        if(usuarioBuscado.isPresent()){
            logger.info("Se encontro el usuario con el id: "+id);
            return ResponseEntity.ok(usuarioBuscado);
        }else{
            logger.info("No se encontro el usuario con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar el usuario con el id: "+id+".");
        }

    }
    @GetMapping("/buscar/{email}")
    public ResponseEntity<Optional<Usuario>> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException{
        logger.info("Llego la peticion de buscar un usuario con la email: "+email);
        Optional<Usuario> usuarioBuscado= usuarioService.buscarPorEmail(email);
        if(usuarioBuscado.isPresent()){
            logger.info("Se encontro el usuario con la email: "+email);
            return ResponseEntity.ok(usuarioBuscado);
        }else{
            logger.info("No se encontro el usuario con la email: "+email);
            throw new ResourceNotFoundException("No se pudo encontrar el usuario con la email: "+email+".");
        }
    }
    @GetMapping("/buscar/{nombreUsuario}")
    public ResponseEntity<Optional<Usuario>> buscarPorNombreUsuario(@PathVariable String nombreUsuario) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar un usuario con la nombreUsuario: "+nombreUsuario);
        Optional<Usuario> usuarioBuscado= usuarioService.buscarPorNombreUsuario(nombreUsuario);
        if(usuarioBuscado.isPresent()){
            logger.info("Se encontro el usuario con la nombreUsuario: "+nombreUsuario);
            return ResponseEntity.ok(usuarioBuscado);
        }else{
            logger.info("No se encontro el usuario con la nombreUsuario: "+nombreUsuario);
            throw new ResourceNotFoundException("No se pudo encontrar el usuario con la nombreUsuario: "+nombreUsuario+".");
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todos los usuarios");
        List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
        if(listaUsuarios.size() > 0){
            logger.info("Existen usuarios");
            return ResponseEntity.ok(listaUsuarios);
        }else{
            logger.info("No existen usuarios");
            throw new ResourceNotFoundException("No hay ningun usuario presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar el usuario con el id: "+id);
        Optional<Usuario> usuarioBuscado = usuarioService.buscarPorId(id);
        if(usuarioBuscado.isPresent()){
            logger.info("Se elimino el usuario con el id: "+id);
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario con el id: "+ id +" eliminado con exito.");
        }else
            logger.info("No se elimino el usuario con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro usuario a eliminar.");
    }
}
