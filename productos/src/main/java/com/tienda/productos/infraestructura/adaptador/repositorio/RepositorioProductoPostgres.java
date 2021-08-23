package com.tienda.productos.infraestructura.adaptador.repositorio;

import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;

import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.CategoriaEntidad;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.ProductoEntidad;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioProductoJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoPostgres implements RepositorioProducto {

    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioProductoJpa repositorioProductoJpa;

    public RepositorioProductoPostgres(RepositorioProductoJpa repositorioProductoJpa) {
        this.repositorioProductoJpa = repositorioProductoJpa;
    }

    @Override
    public void crear(Producto producto) {
        Categoria categoria=producto.getCategoria();
        CategoriaEntidad categoriaEntidad=modelMapper.map(categoria,CategoriaEntidad.class);
        ProductoEntidad productoEntidad=modelMapper.map(producto,ProductoEntidad.class);

        productoEntidad.setCategoriaEntidad(categoriaEntidad);
        this.repositorioProductoJpa.save(productoEntidad);

    }


    @Override
    public boolean existe(Producto producto) {
        String nombre=producto.getNombre();
    if (this.repositorioProductoJpa.ListarPorNombre(nombre).toArray().length == 0){
        return false;
        }
        return true;
    }


}
