package com.tienda.facturas.infraestructura.repositorioJpa;

import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.FacturaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

public interface RepositorioFacturaJpa extends JpaRepository<FacturaEntidad , Serializable> {
    @Query(value = "select * from facturas where facturas.id = :id" , nativeQuery = true)
    FacturaEntidad buscarporid (@PathVariable("id") Long id);
}
