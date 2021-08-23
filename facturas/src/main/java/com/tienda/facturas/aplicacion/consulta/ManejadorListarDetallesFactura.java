package com.tienda.facturas.aplicacion.consulta;

import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;
import com.tienda.facturas.dominio.servicio.ServicioListarDetallesFactura;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarDetallesFactura {
    private final ServicioListarDetallesFactura servicioListarDetallesFactura;

    public ManejadorListarDetallesFactura(ServicioListarDetallesFactura servicioListarDetallesFactura) {
        this.servicioListarDetallesFactura = servicioListarDetallesFactura;
    }
    public List<DetalleFacturaDto> ejecutar(Long id){
        return servicioListarDetallesFactura.listarTodos(id);
    }
}
