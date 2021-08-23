package com.tienda.personas.dominio.validador;

import com.tienda.personas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.tienda.personas.dominio.excepcion.ExcepcionLongitud;


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
    public static void validarLongitud(Long id, String mensaje) {
        if (id.toString().length() < 5 || id.toString().length() > 10) {
            {
                throw new ExcepcionLongitud(mensaje);
            }

            }

    }
}
