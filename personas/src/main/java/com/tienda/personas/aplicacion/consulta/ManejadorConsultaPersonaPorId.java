package com.tienda.personas.aplicacion.consulta;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import com.tienda.personas.dominio.servicio.ServicioConsultarPersona;
import org.springframework.stereotype.Component;



@Component
public class ManejadorConsultaPersonaPorId {
    private final ServicioConsultarPersona servicioConsultarPersona;

    public ManejadorConsultaPersonaPorId(ServicioConsultarPersona servicioConsultarPersona) {
        this.servicioConsultarPersona = servicioConsultarPersona;
    }
    public PersonasDto ejecutar(Long id){
        return this.servicioConsultarPersona.buscarporId(id);
    }
}
