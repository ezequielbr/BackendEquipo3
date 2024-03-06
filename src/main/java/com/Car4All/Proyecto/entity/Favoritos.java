package com.Car4All.Proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @OneToOne
    @JoinColumn(name ="usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToMany
    @JoinTable(
            name = "favoritos_autos",
            joinColumns = @JoinColumn(name = "favorito_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auto_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Auto> autos= new HashSet<>();

}