package com.tienda.productos.infraestructura.repositorioJpa;

import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.ProductoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;


public interface RepositorioProductoJpa extends JpaRepository<ProductoEntidad, Serializable> {
    @Query(value = "select * from productos where productos.id = :id ", nativeQuery = true)
    ProductoEntidad ListarPorId(@Param("id") Long id);

    @Query(value = "select * from productos where productos.nombre = :nombre", nativeQuery = true)
    List<ProductoEntidad> ListarPorNombre(@Param("nombre") String nombre);


}
