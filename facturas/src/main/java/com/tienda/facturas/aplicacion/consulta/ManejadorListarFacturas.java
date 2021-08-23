package com.tienda.facturas.aplicacion.consulta;

import com.tienda.facturas.dominio.modelo.dto.FacturaDto;
import com.tienda.facturas.dominio.servicio.ServicioListarFacturas;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarFacturas {
    private final ServicioListarFacturas servicioListarFacturas;

    public ManejadorListarFacturas(ServicioListarFacturas servicioListarFacturas) {
        this.servicioListarFacturas = servicioListarFacturas;
    }
    public List<FacturaDto> ejecutar(){
        return servicioListarFacturas.listarTodos();
    }
}
