package com.tienda.facturas.dominio.puerto.dao;

import com.tienda.facturas.dominio.modelo.dto.FacturaDto;

import java.util.List;

public interface FacturaDao {
    FacturaDto buscarPorId(Long id);
    List<FacturaDto>listarTodos();
}
