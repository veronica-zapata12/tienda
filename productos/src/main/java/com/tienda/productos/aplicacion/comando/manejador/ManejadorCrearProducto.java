package com.tienda.productos.aplicacion.comando.manejador;

import com.tienda.productos.aplicacion.comando.ComandoProducto;
import com.tienda.productos.aplicacion.comando.fabrica.FabricaProducto;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto {
    private final ServicioCrearProducto servicioCrearProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorCrearProducto(ServicioCrearProducto servicioCrearProducto, FabricaProducto fabricaProducto) {
        this.servicioCrearProducto = servicioCrearProducto;
        this.fabricaProducto = fabricaProducto;
    }
    public void ejecutar(ComandoProducto comandoProducto){
        Producto producto=this.fabricaProducto.crear(comandoProducto);
        this.servicioCrearProducto.ejecutar(producto);
    }
}
