package com.tienda.productos.testDominio;

import com.tienda.productos.dominio.excepcion.ExcepcionCampoObligatorio;
import com.tienda.productos.dominio.excepcion.ExcepcionCantidad;
import com.tienda.productos.dominio.excepcion.ExcepcionDuplicidad;
import com.tienda.productos.dominio.excepcion.ExcepcionGeneral;
import com.tienda.productos.dominio.modelo.entidad.Producto;
import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;
import com.tienda.productos.dominio.servicio.ServicioCrearProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearProductoTest {
    private RepositorioProducto repositorioProducto;
    private DaoCategoria daoCategoria;
    private ServicioCrearProducto servicioCrearProducto;

    @BeforeEach
    public void crear() {
        daoCategoria = Mockito.mock(DaoCategoria.class);

        repositorioProducto = Mockito.mock(RepositorioProducto.class);
        servicioCrearProducto = new ServicioCrearProducto(repositorioProducto, daoCategoria);
    }
    @Test
    public void crearProducto(){
        Producto producto=new ProductoDataBuilder().build();
        Mockito.when(daoCategoria.findByCategoria(producto.getCategoria().getNombre())).thenReturn(true);
        servicioCrearProducto.ejecutar(producto);
        Assertions.assertEquals("TENIS",producto.getNombre());
        Assertions.assertEquals("zapatos",producto.getCategoria().getNombre());
        Assertions.assertEquals(20.5,producto.getCantidad());

    }
    @Test
    public void crearProductoSinNombre(){
        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new ProductoDataBuilder().sinNombre(null).build(), "el nombre es obligatorio");

    }
    @Test
    public void crearProductoSinCantidad(){
        Assertions.assertThrows(ExcepcionCantidad.class, () ->
                new ProductoDataBuilder().sinCantidad(0.0).build(), "la cantidad debe ser mayor a cero");

    }
    @Test
    public void crearProductoExistente(){
        Producto producto=new ProductoDataBuilder().build();
        Mockito.when(daoCategoria.findByCategoria(producto.getCategoria().getNombre())).thenReturn(true);
        Mockito.when(repositorioProducto.existe(producto)).thenReturn(true);
        Assertions.assertThrows(ExcepcionDuplicidad.class,() -> servicioCrearProducto.ejecutar(producto), "El producto ya existe en el sistema");


    }
    @Test
    public void crearProductoSinCategoriaExistente(){
        Producto producto=new ProductoDataBuilder().build();
        Mockito.when(daoCategoria.findByCategoria(producto.getCategoria().getNombre())).thenReturn(false);

        Assertions.assertThrows(ExcepcionGeneral.class,() -> servicioCrearProducto.ejecutar(producto), "la categoria no existe en el sistema");


    }
}
