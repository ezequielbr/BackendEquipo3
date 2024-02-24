package com.Car4All.Proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NonNull
    private String userName;
    @Column(nullable = false)
    @NonNull
    private String password;
    @Column(nullable = false,unique = true)
    @NonNull
    private String email;
    @Column
    @NonNull
    private UsuarioRole usuarioRole;

}
