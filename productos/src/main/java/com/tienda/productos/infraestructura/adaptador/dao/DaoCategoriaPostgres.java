package com.tienda.productos.infraestructura.adaptador.dao;

import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioCategoriaJpa;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCategoriaPostgres implements DaoCategoria {
    private final RepositorioCategoriaJpa repositorioCategoriaJpa;

    public DaoCategoriaPostgres(RepositorioCategoriaJpa repositorioCategoriaJpa) {
        this.repositorioCategoriaJpa = repositorioCategoriaJpa;
    }

    @Override
    public boolean findByCategoria(String nombre) {
        return (repositorioCategoriaJpa.ListarPorCategoria(nombre))==null ? false:true;
    }
}
