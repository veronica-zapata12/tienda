package com.tienda.facturas.dominio.modelo.entidad;

import com.tienda.facturas.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;

@Getter
public class DetalleFactura {
    private static final String LA_CATIDAD_DEBE_SER_MAYOR_A_CERO="la cantidad debe ser mayor a cero";
    private static final String EL_PRECIO_DEBE_SER_MAYOR_A_CERO="el precio debe ser mayor a cero";
    private Long id;
    private Double cantidad;
    private double precio;


    public DetalleFactura(Long id, Double cantidad, Double precio) {
        ValidadorDeArgumento.validarNumeroMayor(cantidad,LA_CATIDAD_DEBE_SER_MAYOR_A_CERO);
        ValidadorDeArgumento.validarPrecioNumeroMayor(precio,EL_PRECIO_DEBE_SER_MAYOR_A_CERO);
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;

    }
    public Double calcularParcial(){
        return cantidad*precio;
    }
}
