package com.tienda.productos.aplicacion.consulta;

import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.servicio.ServicioListarProductos;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaProductosPorId {
    private final ServicioListarProductos servicioListarProductos;

    public ManejadorConsultaProductosPorId(ServicioListarProductos servicioListarProductos) {
        this.servicioListarProductos = servicioListarProductos;
    }
    public ProductoDto ejecutar(Long id){
        return this.servicioListarProductos.buscarPorId(id);
    }
}
