package com.Car4All.Proyecto.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @OneToOne
    @JoinColumn(name ="usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToMany
    @JoinTable(
            name = "carrito_autos",
            joinColumns = @JoinColumn(name = "carrito_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auto_id",referencedColumnName = "id"))
    @JsonIgnore
    private Set<Auto> autos= new HashSet<>();
    @NonNull
    @Column
    private LocalDate fechaAdicion;

}