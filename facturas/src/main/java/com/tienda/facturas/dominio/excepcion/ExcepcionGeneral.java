package com.tienda.facturas.dominio.excepcion;

public class ExcepcionGeneral extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionGeneral(String mensaje) {
        super(mensaje);
    }

}
