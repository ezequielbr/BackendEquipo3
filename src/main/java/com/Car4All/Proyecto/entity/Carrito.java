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
    @OneToMany(mappedBy ="carrito", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Auto> autos= new HashSet<>();
    @NonNull
    @Column
    private LocalDate fechaAdicion;

}