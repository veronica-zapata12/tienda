package com.tienda.facturas.dominio.servicio;

import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;
import com.tienda.facturas.dominio.puerto.dao.DetallesFacturaDao;

import java.util.List;

public class ServicioListarDetallesFactura {
    private final DetallesFacturaDao detallesFacturaDao;

    public ServicioListarDetallesFactura(DetallesFacturaDao detallesFacturaDao) {
        this.detallesFacturaDao = detallesFacturaDao;
    }
    public List<DetalleFacturaDto> listarTodos(Long id){
        return detallesFacturaDao.buscarFactura(id);
    }
}
