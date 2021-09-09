package com.tienda.productos.infraestructura.controlador;

import com.tienda.productos.aplicacion.comando.ComandoProducto;
import com.tienda.productos.aplicacion.comando.manejador.ManejadorCrearProducto;
import com.tienda.productos.aplicacion.consulta.ManejadorConsultaCategorias;
import com.tienda.productos.aplicacion.consulta.ManejadorConsultaProductosPorId;
import com.tienda.productos.aplicacion.consulta.ManejadorConsultarProductos;
import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.modelo.dto.ProductoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/productos")
public class ControladorProducto {
    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorConsultarProductos manejadorConsultarProductos;
    private final ManejadorConsultaProductosPorId manejadorConsultaProductosPorId;
    private final ManejadorConsultaCategorias manejadorConsultaCategorias;



    public ControladorProducto(ManejadorCrearProducto manejadorCrearProducto, ManejadorConsultarProductos manejadorConsultarProductos, ManejadorConsultaProductosPorId manejadorConsultaProductosPorId, ManejadorConsultaCategorias manejadorConsultaCategorias) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorConsultarProductos = manejadorConsultarProductos;
        this.manejadorConsultaProductosPorId = manejadorConsultaProductosPorId;
        this.manejadorConsultaCategorias = manejadorConsultaCategorias;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crearProducto(@RequestBody  ComandoProducto comandoProducto){
        this.manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoDto> consultarTodos(){
        return this.manejadorConsultarProductos.ejecutar();
    }

    @GetMapping(value = "/{id}")
    public ProductoDto consultarPorId(@PathVariable Long id){
        return this.manejadorConsultaProductosPorId.ejecutar(id);
    }
    @GetMapping(value = "/categoria/{id}")
    public List<ProductoDto> consultarPorCategoria(@PathVariable Long id){
        return this.manejadorConsultarProductos.categoria(id);
    }
    @GetMapping(value = "/categoria")
    public List<CategoriaDto> consultarCategorias(){
        return this.manejadorConsultaCategorias.ejecutar();
    }

}
