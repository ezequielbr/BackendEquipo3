package com.Car4All.Proyecto.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario /*implements UserDetails*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NonNull
    private String nombreUsuario;
    @Column(nullable = false)
    @NonNull
    private String password;
    @Column(nullable = false,unique = true)
    @NonNull
    private String email;
    @Column
    @NonNull
    private UsuarioRol usuarioRol;
    @NonNull
    @Column
    private String nombre;
    @Column
    @NonNull
    private String apellido;
    @Column
    @NonNull
    private Integer dni;
    @Column
    @NonNull
    private Boolean inicioSesion;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrito_id",referencedColumnName = "id")
    @JsonIgnore
    private Carrito carrito = new Carrito();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favoritos_id",referencedColumnName = "id")
    @JsonIgnore
    private Favoritos favoritos = new Favoritos();;
    @OneToMany
    @JoinColumn(name = "valoracion_id",referencedColumnName = "id")
    @JsonIgnore
    private Set<Valoracion> valoraciones= new HashSet<>();


//    private void init() {
//        carrito = new Carrito();
//        favoritos = new Favoritos();
//    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new SimpleGrantedAuthority(usuarioRol.toString()));
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return nombreUsuario;
//    }
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
