package com.tienda.productos.dominio.puerto.dao;

import com.tienda.productos.dominio.modelo.dto.ProductoDto;

import java.util.List;

public interface DaoProducto {
    ProductoDto buscarPorID(Long id);
    List<ProductoDto> mostrarTodos();
    List<ProductoDto> mostrarPorCategoria(Long id);



}
