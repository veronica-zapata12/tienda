package com.tienda.facturas.dominio.excepcion;

public class ExcepcionPrecioMayorDeCero extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ExcepcionPrecioMayorDeCero (String mensaje) {
        super(mensaje);
    }
}
