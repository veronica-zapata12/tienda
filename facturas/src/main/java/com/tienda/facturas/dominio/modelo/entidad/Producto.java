package com.tienda.facturas.dominio.modelo.entidad;


import com.tienda.facturas.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;

import java.util.Date;

@Getter
public class Producto {

    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;
    private Date fechaCreacion;
    private Categoria categoria;

    public Producto(long id, String nombre, String descripcion, Double cantidad, Double precio, String estado, Categoria categoria) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;


        this.categoria = categoria;
    }


}
