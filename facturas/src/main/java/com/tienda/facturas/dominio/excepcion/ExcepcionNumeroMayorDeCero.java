package com.tienda.facturas.dominio.excepcion;

public class ExcepcionNumeroMayorDeCero extends RuntimeException {

    public ExcepcionNumeroMayorDeCero(String mensaje) {
        super(mensaje);
    }
}
