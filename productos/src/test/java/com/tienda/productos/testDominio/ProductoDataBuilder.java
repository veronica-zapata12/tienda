package com.tienda.productos.testDominio;

import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;


public class ProductoDataBuilder {
    private static final Long ID=1l;
    private static final String NOMBRE="TENIS";
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

    public ProductoDataBuilder() {
        this.id= ID;
        this.nombre=NOMBRE;
        this.descripcion=DESCRIPCION;
        this.cantidad=CANTIDAD;
        this.precio=PRECIO;
        this.estado=ESTADO;
        this.categoria=new CategoriaDataBuilder().build();

    }
    public ProductoDataBuilder sinNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public ProductoDataBuilder sinCantidad(Double cantidad){
        this.cantidad=cantidad;
        return this;
    }
    public Producto build(){
        return new Producto(this.id,this.nombre,this.descripcion,this.cantidad,this.precio,this.estado,this.categoria);
    }
}
