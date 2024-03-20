//package com.Car4All.Proyecto.security;
//
//
//import com.Car4All.Proyecto.entity.Usuario;
//import com.Car4All.Proyecto.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.Optional;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    @Autowired
//    private UsuarioService usuarioService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//        @Bean
//        public UserDetailsService userDetailsService() {
//            return nombreUsuario -> {
//                Optional<Usuario> usuarioOptional = usuarioService.buscarPorNombreUsuario(nombreUsuario);
//                if (usuarioOptional.isEmpty()) {
//                     throw new UsernameNotFoundException("Usuario no encontrado");
//                } else {
//                    return usuarioOptional.get();
//                }
//            };
//        }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/login").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .permitAll()
//                        .defaultSuccessUrl("/h2-console", true)
//                )
//                .userDetailsService(userDetailsService());
//
//        return http.build();
//    }
//
//}
