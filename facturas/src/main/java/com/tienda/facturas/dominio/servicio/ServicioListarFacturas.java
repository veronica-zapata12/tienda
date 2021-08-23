package com.tienda.facturas.dominio.servicio;

import com.tienda.facturas.dominio.modelo.dto.FacturaDto;
import com.tienda.facturas.dominio.puerto.dao.FacturaDao;

import java.util.List;

public class ServicioListarFacturas {
    private final FacturaDao facturaDao;

    public ServicioListarFacturas(FacturaDao facturaDao) {
        this.facturaDao = facturaDao;
    }
    public FacturaDto buscarPorId(Long id){
        return this.facturaDao.buscarPorId(id);
    }
    public List<FacturaDto> listarTodos(){
        return this.facturaDao.listarTodos();
    }
}
