package com.Car4All.Proyecto.security;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Domicilio;
import com.Car4All.Proyecto.entity.Usuario;
import com.Car4All.Proyecto.entity.UsuarioRol;
import com.Car4All.Proyecto.repository.AutoRepository;
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
    private AutoRepository autoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
//        String clave = cifrador.encode("digital");
//        System.out.println("Clave cifrada: "+cifrador);
        Usuario usuario1= new Usuario("EzequielB","hola","ezequielbravo00@gmail.com",UsuarioRol.ROLE_ADMIN,"Ezequiel","Bravo",42711202,false,new Domicilio("SA",2,"SA","SA"));
        usuarioRepository.save(usuario1);
        Auto auto1= new Auto("Corolla 1.8 XEI Pack CVT","Toyota",5,"Nafta","Manual","Argentina",true,"SPX983",false,"https://autos.hamariweb.com/images/carimages/BBCQG0U.jpg");
        autoRepository.save(auto1);
        Auto auto3= new Auto("F100","Ford",5,"GasOil","Manual","Argentina",true,"SPX983",false,"https://autos.hamariweb.com/images/carimages/BBCQG0U.jpg");
        autoRepository.save(auto1);
//        Usuario admin1= new Usuario("Vanesa","vanesa","vanesagarzon@digitalhouse.com",clave, UsuarioRol.ROLE_ADMIN);
//        usuarioRepository.save(admin1);


    }
}
