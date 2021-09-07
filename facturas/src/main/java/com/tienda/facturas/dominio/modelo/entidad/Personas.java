package com.tienda.facturas.dominio.modelo.entidad;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Personas {
    private Long id;
    private String nombre;

    public Personas(Long id, String nombre) {

        this.id = id;
        this.nombre = nombre;
    }
}
