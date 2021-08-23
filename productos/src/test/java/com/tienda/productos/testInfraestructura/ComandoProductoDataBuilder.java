package com.tienda.productos.testInfraestructura;

import com.tienda.productos.aplicacion.comando.ComandoProducto;
import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.testDominio.CategoriaDataBuilder;


public class ComandoProductoDataBuilder {
    private static final Long ID=1l;
    private static final String NOMBRE="trote";
    private static final String DESCRIPCION="deportivos";
    private static final Double CANTIDAD=20.5;
    private static final Double PRECIO=200.5;
    private static final String ESTADO="CREADO";
    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;
    private Categoria categoria;

    public ComandoProductoDataBuilder() {
        this.id= ID;
        this.nombre=NOMBRE;
        this.descripcion=DESCRIPCION;
        this.cantidad=CANTIDAD;
        this.precio=PRECIO;
        this.estado=ESTADO;
        this.categoria=new CategoriaDataBuilder().build();

    }
    public ComandoProductoDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ComandoProducto build(){
        return new ComandoProducto(this.id,this.nombre,this.descripcion,this.cantidad,this.precio,this.estado,this.categoria);
    }
}
