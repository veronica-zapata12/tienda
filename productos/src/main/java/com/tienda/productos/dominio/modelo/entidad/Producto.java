package com.tienda.productos.dominio.modelo.entidad;

import com.tienda.productos.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;

import java.util.Date;
@Getter
public class Producto {
    private static final String EL_NOMBRE_ES_OBLIGATORIO="el nombre es obligatorio";
    private static final String LA_CATIDAD_DEBE_SER_MAYOR_A_CERO="la cantidad debe ser mayor a cero";
    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;
    private Date fechaCreacion;
    private Categoria categoria;

    public Producto(long id, String nombre, String descripcion, Double cantidad, Double precio, String estado, Categoria categoria) {
        ValidadorDeArgumento.validarObligatorio(nombre,EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarCantidad(cantidad,LA_CATIDAD_DEBE_SER_MAYOR_A_CERO);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
        this.fechaCreacion = calcularFecha(new Date());

        this.categoria = categoria;
    }

    public Date calcularFecha(Date fecha){
       return ValidadorDeArgumento.validarFecha(fecha);
    }
}
