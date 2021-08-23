package com.tienda.productos.dominio.servicio;

import com.tienda.productos.dominio.excepcion.ExcepcionDuplicidad;
import com.tienda.productos.dominio.excepcion.ExcepcionGeneral;
import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {
    private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA = "El producto ya existe en el sistema";
    private static final String LA_CATEGORIA_NO_EXISTE_EN_EL_SISTEMA = "la categoria no existe en el sistema";
    private final RepositorioProducto repositorioProducto;
    private final DaoCategoria daoCategoria;


    public ServicioCrearProducto(RepositorioProducto repositorioProducto, DaoCategoria daoCategoria) {
        this.repositorioProducto = repositorioProducto;
        this.daoCategoria = daoCategoria;
    }
    public void ejecutar(Producto producto){
        validarExistenciaPreviaCategoria(producto.getCategoria());
        validarExistenciaPreviaProducto(producto);
        this.repositorioProducto.crear(producto);
    }
    private void validarExistenciaPreviaProducto(Producto producto) {
        boolean existe =this.repositorioProducto.existe(producto);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaCategoria(Categoria categoria) {
        boolean existe = daoCategoria.findByCategoria(categoria.getNombre());
        if(!existe) {
            throw new ExcepcionGeneral(LA_CATEGORIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
