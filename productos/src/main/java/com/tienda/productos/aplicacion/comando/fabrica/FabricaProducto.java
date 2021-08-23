package com.tienda.productos.aplicacion.comando.fabrica;

import com.tienda.productos.aplicacion.comando.ComandoProducto;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {
    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getCantidad(),
                comandoProducto.getPrecio(),
                comandoProducto.getEstado(),
                comandoProducto.getCategoria());
    }
}
