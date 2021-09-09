package com.tienda.productos.dominio.puerto.dao;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;


import java.util.List;

public interface DaoCategoria {
    boolean findByCategoria(String nombre);
    List<CategoriaDto>mostrarTodasCategorias();
}
