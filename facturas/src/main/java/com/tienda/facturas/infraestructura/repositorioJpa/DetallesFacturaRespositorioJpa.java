package com.tienda.facturas.infraestructura.repositorioJpa;

import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.DetallesFacturaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

public interface DetallesFacturaRespositorioJpa extends JpaRepository<DetallesFacturaEntidad, Serializable> {
    @Query(value = "select * from detalles_factura   where detalles_id = :id",nativeQuery = true)
    List<DetallesFacturaEntidad> buscarfacturaporid (@PathVariable("id") Long id);
}
