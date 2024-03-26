package com.Car4All.Proyecto.security;

import com.Car4All.Proyecto.entity.Domicilio;
import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.entity.UsuarioRol;
import com.Car4All.Proyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CargadorInicial implements ApplicationRunner {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
//        String clave = cifrador.encode("digital");
//        System.out.println("Clave cifrada: "+cifrador);
        Usuario usuario1= new Usuario("EzequielB","hola","ezequielbravo00@gmail.com",UsuarioRol.ROLE_ADMIN,"Ezequiel","Bravo",42711202,false,new Domicilio("SA",2,"SA","SA"));
        usuarioRepository.save(usuario1);
//        Usuario admin1= new Usuario("Vanesa","vanesa","vanesagarzon@digitalhouse.com",clave, UsuarioRol.ROLE_ADMIN);
//        usuarioRepository.save(admin1);


    }
}
