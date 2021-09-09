package com.tienda.productos.infraestructura.adaptador.dao;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.CategoriaEntidad;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.ProductoEntidad;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioCategoriaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoCategoriaPostgres implements DaoCategoria {
    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioCategoriaJpa repositorioCategoriaJpa;

    public DaoCategoriaPostgres(RepositorioCategoriaJpa repositorioCategoriaJpa) {
        this.repositorioCategoriaJpa = repositorioCategoriaJpa;
    }

    @Override
    public boolean findByCategoria(String nombre) {
        return (repositorioCategoriaJpa.ListarPorCategoria(nombre))==null ? false:true;
    }

    @Override
    public List<CategoriaDto> mostrarTodasCategorias() {
        List<CategoriaEntidad>categoriaEntidadsList=repositorioCategoriaJpa.findAll();
        List<CategoriaDto> categoriaDtoList=new ArrayList<>();
        for (CategoriaEntidad categoriaEntidad:categoriaEntidadsList){
            CategoriaDto categoriaDto=modelMapper.map(categoriaEntidad,CategoriaDto.class);
            categoriaDtoList.add(categoriaDto);
        }
        return categoriaDtoList;
    }
}
