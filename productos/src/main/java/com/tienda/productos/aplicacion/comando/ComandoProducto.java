package com.tienda.productos.aplicacion.comando;

import com.tienda.productos.dominio.modelo.entidad.Categoria;

import lombok.Getter;



@Getter
public class ComandoProducto {
    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;;
    private Categoria categoria;

    public ComandoProducto(long id, String nombre, String descripcion, Double cantidad, Double precio, String estado, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
    }
}

