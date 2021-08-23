package com.tienda.personas.aplicacion.consulta;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import com.tienda.personas.dominio.servicio.ServicioConsultarPersona;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultarPersonas {
    private final ServicioConsultarPersona servicioConsultarPersona;

    public ManejadorConsultarPersonas(ServicioConsultarPersona servicioConsultarPersona) {
        this.servicioConsultarPersona = servicioConsultarPersona;
    }
    public List<PersonasDto> ejecutar(){
        return this.servicioConsultarPersona.listarPersonas();
    }
}
