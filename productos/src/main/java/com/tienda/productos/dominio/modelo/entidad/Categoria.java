package com.tienda.productos.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Categoria {
    private long id;

    private String nombre;
}
