package com.tienda.personas.infraestructura.adaptador.repositorio;

import com.tienda.personas.dominio.modelo.entidad.Personas;
import com.tienda.personas.dominio.puerto.repositorio.RepositorioPersonas;
import com.tienda.personas.infraestructura.adaptador.repositorio.entidades.PersonaEntidad;
import com.tienda.personas.infraestructura.repositorioJpa.RepositorioPersonaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaPostgres implements RepositorioPersonas {
    private ModelMapper modelMapper=new ModelMapper();
    private  final RepositorioPersonaJpa repositorioPersonaJpa;

    public RepositorioPersonaPostgres(RepositorioPersonaJpa repositorioPersonaJpa) {
        this.repositorioPersonaJpa = repositorioPersonaJpa;
    }

    @Override
    public void crear(Personas personas) {
        PersonaEntidad personaEntidad= modelMapper.map(personas,PersonaEntidad.class);
        this.repositorioPersonaJpa.save(personaEntidad);

    }

    @Override
    public boolean existe(Personas personas) {
        Long id=personas.getId();
        return this.repositorioPersonaJpa.buscarPorId(id) !=null ? true : false;

    }
}
