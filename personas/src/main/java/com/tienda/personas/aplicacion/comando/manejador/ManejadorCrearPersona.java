package com.tienda.personas.aplicacion.comando.manejador;


import com.tienda.personas.aplicacion.comando.ComandoPersona;
import com.tienda.personas.aplicacion.comando.fabrica.FabricaPersona;
import com.tienda.personas.dominio.modelo.entidad.Personas;
import com.tienda.personas.dominio.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona {

    private final ServicioCrearPersona servicioCrearPersona;
    private final FabricaPersona fabricaPersona;

    public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {
        this.servicioCrearPersona = servicioCrearPersona;
        this.fabricaPersona = fabricaPersona;
    }
    public  void ejecutar(ComandoPersona comandoPersona){
        Personas personas= this.fabricaPersona.crear(comandoPersona);
        this.servicioCrearPersona.ejecutar(personas);
    }
}
