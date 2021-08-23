package com.tienda.facturas.aplicacion.consulta;

import com.tienda.facturas.dominio.modelo.dto.FacturaDto;
import com.tienda.facturas.dominio.servicio.ServicioListarFacturas;
import org.springframework.stereotype.Component;



@Component
public class ManejadorListarFacturasPorId {
    private final ServicioListarFacturas servicioListarFacturas;

    public ManejadorListarFacturasPorId(ServicioListarFacturas servicioListarFacturas) {
        this.servicioListarFacturas = servicioListarFacturas;
    }
    public FacturaDto ejecutar(Long id){
        return servicioListarFacturas.buscarPorId(id);
    }
}
