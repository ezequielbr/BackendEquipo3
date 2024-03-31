package com.Car4All.Proyecto.entity.dto;

import com.Car4All.Proyecto.entity.UsuarioRol;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String nombre;
    @NonNull
    private UsuarioRol usuarioRol;
}
