package com.tienda.personas.infraestructura.adaptador.dao;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import com.tienda.personas.dominio.puerto.dao.DaoPersonas;
import com.tienda.personas.infraestructura.adaptador.repositorio.entidades.PersonaEntidad;
import com.tienda.personas.infraestructura.repositorioJpa.RepositorioPersonaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DaoPersonaPostgres implements DaoPersonas {
    private ModelMapper modelMapper=new ModelMapper();
    private  final RepositorioPersonaJpa repositorioPersonaJpa;

    public DaoPersonaPostgres(RepositorioPersonaJpa repositorioPersonaJpa) {
        this.repositorioPersonaJpa = repositorioPersonaJpa;
    }

    @Override
    public PersonasDto buscarPorId(Long id) {
        PersonaEntidad personaEntidad=this.repositorioPersonaJpa.buscarPorId(id);
        PersonasDto personasDto=modelMapper.map(personaEntidad,PersonasDto.class);
        return personasDto;
    }

    @Override
    public List<PersonasDto> listarPersonas() {
        List<PersonaEntidad> personaEntidadList=this.repositorioPersonaJpa.findAll();
        List<PersonasDto> personasDtoList=new ArrayList<>();
        for(PersonaEntidad  personaEntidad:personaEntidadList){
            PersonasDto personasDto =modelMapper.map(personaEntidad,PersonasDto.class);
            personasDtoList.add(personasDto);
        }
        return personasDtoList;
    }

    @Override
    public boolean existeId(Long id) {
        return this.repositorioPersonaJpa.buscarPorId(id) !=null ? true : false;
    }
}
