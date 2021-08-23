package com.tienda.personas.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntidad {
    @Id
    @Column
    private Long id;

    @Column
    private String nombre;
}
