package com.tienda.facturas.dominio.puerto.dao;

import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;

import java.util.List;

public interface DetallesFacturaDao {
    List<DetalleFacturaDto> buscarFactura(Long id);
}
