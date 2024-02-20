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
    @NonNull
    @Column
    private String nombre;
    @NonNull
    @Column
    private String apellido;
    @NonNull
    @Column(nullable = false)
    private String dni;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;
    @Column
    @NonNull
    private UsuarioRole usuarioRole;

}
