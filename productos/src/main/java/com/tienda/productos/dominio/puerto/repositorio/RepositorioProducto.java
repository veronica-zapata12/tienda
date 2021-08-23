package com.tienda.productos.dominio.puerto.repositorio;

import com.tienda.productos.dominio.modelo.entidad.Producto;

public interface RepositorioProducto {
    void crear(Producto producto);
    boolean existe(Producto producto);
}
