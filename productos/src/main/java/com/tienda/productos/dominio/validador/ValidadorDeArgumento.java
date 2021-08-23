package com.tienda.productos.dominio.validador;

import com.tienda.productos.dominio.excepcion.ExcepcionCampoObligatorio;
import com.tienda.productos.dominio.excepcion.ExcepcionCantidad;

import java.util.Calendar;
import java.util.Date;

public class ValidadorDeArgumento {
    public ValidadorDeArgumento() {
    }
    public static void validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            {
                throw new ExcepcionCampoObligatorio(mensaje);
            }
        }
    }
    public static void validarCantidad(Double valor, String mensaje) {
        if (valor <= 0) {
            {
                throw new ExcepcionCantidad(mensaje);
            }
        }
    }
    public static Date validarFecha(Date fecha){
        int diaAdicional=1;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int diaDomingo = calendar.get(Calendar.DAY_OF_WEEK);
        if (diaDomingo == Calendar.THURSDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, diaAdicional);

        }
        return calendar.getTime();
    }
}
