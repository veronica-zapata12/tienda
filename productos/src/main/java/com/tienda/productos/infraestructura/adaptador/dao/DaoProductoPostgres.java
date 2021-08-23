package com.tienda.productos.infraestructura.adaptador.dao;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.puerto.dao.DaoProducto;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.CategoriaEntidad;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.ProductoEntidad;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioProductoJpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DaoProductoPostgres implements DaoProducto {
    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioProductoJpa repositorioProductoJpa;

    public DaoProductoPostgres(RepositorioProductoJpa repositorioProductoJpa) {
        this.repositorioProductoJpa = repositorioProductoJpa;
    }

    @Override
    public ProductoDto buscarPorID(Long id) {
        ProductoEntidad productoEntidad=repositorioProductoJpa.ListarPorId(id);
        ProductoDto productoDto= modelMapper.map(productoEntidad,ProductoDto.class);
        return productoDto;
    }

    @Override
    public List<ProductoDto> mostrarTodos() {

        List<ProductoEntidad>productoEntidadsList=repositorioProductoJpa.findAll();
        List<ProductoDto> productoDtoList=new ArrayList<>();
        for (ProductoEntidad productoEntidad:productoEntidadsList){
            ProductoDto productoDto=modelMapper.map(productoEntidad,ProductoDto.class);
            productoDtoList.add(productoDto);
        }
        return productoDtoList;

    }

    @Override
    public List<ProductoDto> mostrarPorCategoria(Long id) {
        List<ProductoEntidad>productoEntidadsList=repositorioProductoJpa.findAll();
        List<ProductoDto> productoDtoList=new ArrayList<>();
        for (ProductoEntidad productoEntidad:productoEntidadsList){
            if(id == productoEntidad.getCategoriaEntidad().getId()){

            ProductoDto productoDto=modelMapper.map(productoEntidad,ProductoDto.class);
            productoDtoList.add(productoDto);
            }
        }
        return productoDtoList;
    }

}
