package com.tienda.productos.aplicacion.consulta;

import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.servicio.ServicioListarProductos;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultarProductos {
    private  final ServicioListarProductos servicioListarProductos;


    public ManejadorConsultarProductos(ServicioListarProductos servicioListarProductos) {
        this.servicioListarProductos = servicioListarProductos;
    }
    public List<ProductoDto> ejecutar(){
        return this.servicioListarProductos.listarTodos();
    }

    public List<ProductoDto> categoria(Long id){
        return this.servicioListarProductos.listarPorCategoria(id);
    }
}
