package com.tienda.personas.dominio.servicio;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import com.tienda.personas.dominio.puerto.dao.DaoPersonas;
import com.tienda.personas.dominio.puerto.repositorio.RepositorioPersonas;

import java.util.List;

public class ServicioConsultarPersona {
    private final DaoPersonas daoPersonas;


    public ServicioConsultarPersona(DaoPersonas daoPersonas) {
        this.daoPersonas = daoPersonas;

    }
    public PersonasDto buscarporId(Long id){
        boolean existeId=this.daoPersonas.existeId(id);
        if (existeId) {
            return this.daoPersonas.buscarPorId(id);
        }
        return null;

    }

    public List<PersonasDto> listarPersonas(){
        return this.daoPersonas.listarPersonas();
    }

}
