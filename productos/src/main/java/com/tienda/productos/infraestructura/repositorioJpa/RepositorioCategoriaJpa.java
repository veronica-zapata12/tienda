package com.tienda.productos.infraestructura.repositorioJpa;

import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.CategoriaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface RepositorioCategoriaJpa extends JpaRepository<CategoriaEntidad, Serializable> {

    @Query(value = "select * from categoria where categoria.nombre = :nombre ", nativeQuery = true)
    CategoriaEntidad ListarPorCategoria(@Param("nombre") String nombre);
}
