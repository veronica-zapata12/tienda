package com.tienda.productos.testDominio;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import com.tienda.productos.dominio.modelo.entidad.Categoria;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.dominio.puerto.dao.DaoProducto;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;
import com.tienda.productos.dominio.servicio.ServicioCrearProducto;
import com.tienda.productos.dominio.servicio.ServicioListarProductos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioConsultarProductoTest {
    private DaoProducto daoProducto;
    private ServicioListarProductos servicioListarProductos;


    @BeforeEach
    public void init() {


        daoProducto = Mockito.mock(DaoProducto.class);
        servicioListarProductos = new ServicioListarProductos(daoProducto);

    }
    @Test
    public void listarTodos(){
        List<ProductoDto> productoDtoLista= new ArrayList<>();
        Producto producto=new ProductoDataBuilder().build();
        CategoriaDto categoria=new CategoriaDto(1,"zapatos");
        ProductoDto productoDto=new ProductoDto(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getPrecio(), producto.getEstado(),new Date(),categoria);
        productoDtoLista.add(productoDto);
         Mockito.when(daoProducto.mostrarTodos()).thenReturn(productoDtoLista);
        List<ProductoDto> productoDtoList= servicioListarProductos.listarTodos();
        Assertions.assertEquals(1, productoDtoList.size());

    }
    @Test
    public void listarPorCategoria(){
        List<ProductoDto> productoDtoLista= new ArrayList<>();
        Producto producto=new ProductoDataBuilder().build();
        CategoriaDto categoria=new CategoriaDto(1,"zapatos");
        CategoriaDto categoria2=new CategoriaDto(2,"zapatos");
        ProductoDto productoDto=new ProductoDto(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getEstado(),new Date(),categoria);
        productoDtoLista.add(productoDto);
        ProductoDto productoDto1=new ProductoDto(producto.getId(), "corpines", "formal", producto.getPrecio(), producto.getCantidad(), producto.getEstado(),new Date(),categoria);
        productoDtoLista.add(productoDto1);
        //ProductoDto productoDto2=new ProductoDto(producto.getId(), "camisilla", "informal", producto.getPrecio(), producto.getCantidad(), producto.getEstado(),new Date(),categoria2);
        //productoDtoLista.add(productoDto2);
        Mockito.when(daoProducto.mostrarPorCategoria(categoria.getId())).thenReturn(productoDtoLista);
        List<ProductoDto> productoDtoList= servicioListarProductos.listarPorCategoria(categoria.getId());
        Assertions.assertEquals(2, productoDtoList.size());

    }
    @Test
    public void listarPorId(){
        Producto producto=new ProductoDataBuilder().build();
        CategoriaDto categoria=new CategoriaDto(1,"zapatos");
        ProductoDto productoDto=new ProductoDto(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getCantidad(), producto.getPrecio(), producto.getEstado(),new Date(),categoria);

        Mockito.when(daoProducto.buscarPorID(producto.getId())).thenReturn(productoDto);
        ProductoDto productoDto1=servicioListarProductos.buscarPorId(productoDto.getId());
        Assertions.assertEquals(1, productoDto1.getId());
        Assertions.assertEquals("TENIS",productoDto1.getNombre());
        Assertions.assertEquals("zapatos",productoDto1.getCategoria().getNombre());
        Assertions.assertEquals(20.5,productoDto1.getCantidad());

    }
}
