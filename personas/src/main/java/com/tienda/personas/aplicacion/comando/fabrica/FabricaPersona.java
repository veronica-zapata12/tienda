package com.tienda.personas.aplicacion.comando.fabrica;

import com.tienda.personas.aplicacion.comando.ComandoPersona;
import com.tienda.personas.dominio.modelo.entidad.Personas;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Personas crear(ComandoPersona comandoPersona){
        return new Personas(comandoPersona.getId(), comandoPersona.getNombre());
    }
}
