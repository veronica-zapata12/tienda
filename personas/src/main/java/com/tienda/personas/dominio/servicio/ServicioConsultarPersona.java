package com.tienda.personas.dominio.servicio;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import com.tienda.personas.dominio.puerto.dao.DaoPersonas;

import java.util.List;

public class ServicioConsultarPersona {
    private final DaoPersonas daoPersonas;

    public ServicioConsultarPersona(DaoPersonas daoPersonas) {
        this.daoPersonas = daoPersonas;
    }
    public PersonasDto buscarporId(Long id){
        return this.daoPersonas.buscarPorId(id);
    }

    public List<PersonasDto> listarPersonas(){
        return this.daoPersonas.listarPersonas();
    }
}
