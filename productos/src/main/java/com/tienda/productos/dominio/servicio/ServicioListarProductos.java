package com.tienda.productos.dominio.servicio;

import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.puerto.dao.DaoProducto;

import java.util.List;

public class ServicioListarProductos {
    private final DaoProducto daoProducto;

    public ServicioListarProductos(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }
    public ProductoDto buscarPorId(Long id){
        return this.daoProducto.buscarPorID(id);

    }
    public List<ProductoDto> listarTodos(){
        return this.daoProducto.mostrarTodos();
    }
    public List<ProductoDto> listarPorCategoria(Long id){
        return this.daoProducto.mostrarPorCategoria(id);
    }

}
