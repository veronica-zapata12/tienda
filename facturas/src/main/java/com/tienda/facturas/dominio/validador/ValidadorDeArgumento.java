package com.tienda.facturas.dominio.validador;


import com.tienda.facturas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.tienda.facturas.dominio.excepcion.ExcepcionNumeroMayorDeCero;
import com.tienda.facturas.dominio.excepcion.ExcepcionPrecioMayorDeCero;

public class ValidadorDeArgumento {
    public ValidadorDeArgumento() {
    }

    public static void validarObligatorio(long valor, String mensaje) {
        if (valor == 0) {
            {
                throw new ExcepcionCampoObligatorio(mensaje);
            }
        }
    }

    public static void validarNumeroMayor(Double valor, String mensaje) {
        if (valor <= 0) {
            {
                throw new ExcepcionNumeroMayorDeCero(mensaje);
            }
        }

    }
    public static void validarPrecioNumeroMayor(Double valor, String mensaje) {
        if (valor <= 0) {
            {
                throw new ExcepcionPrecioMayorDeCero(mensaje);
            }
        }

    }
    public static  Double calcular(Double cantidad,Double precio){
        Double total=0.0;
         total=cantidad*precio;
         return total;
    }
}
