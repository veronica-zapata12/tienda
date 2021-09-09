package com.tienda.productos.dominio.servicio;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.puerto.dao.DaoCategoria;

import java.util.List;

public class ServicioConsultarCategorias {
    private final DaoCategoria daoCategoria;

    public ServicioConsultarCategorias(DaoCategoria daoCategoria) {
        this.daoCategoria = daoCategoria;
    }
    public List<CategoriaDto>listarTodasCategorias(){
        return this.daoCategoria.mostrarTodasCategorias();
    }
}
