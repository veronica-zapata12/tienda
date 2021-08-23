package com.tienda.personas.dominio.puerto.repositorio;

import com.tienda.personas.dominio.modelo.entidad.Personas;

public interface RepositorioPersonas {
    void crear(Personas personas);
    boolean existe(Personas personas);
}
