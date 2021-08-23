package com.tienda.personas.dominio.modelo.entidad;


import com.tienda.personas.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Personas {
    private static  final String EL_NOMBRE_ES_OBLIGATORIO="el nombre es obligatorio";
    private static  final String EL_ID_ES_OBLIGATORIO="el id es obligatorio";
    private static  final String EL_ID_DEBE_SER_MAYOR_O_MENOR="el id debe ser mayor a 5 y menor que 10";
    private Long id;
    private String nombre;

    public Personas(Long id, String nombre) {
        ValidadorDeArgumento.validarObligatorio(nombre,EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarObligatorio(id.toString(),EL_ID_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarLongitud(id,EL_ID_DEBE_SER_MAYOR_O_MENOR);
        this.id = id;
        this.nombre = nombre;
    }
}
