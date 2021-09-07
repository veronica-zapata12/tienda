package com.tienda.facturas.infraestructura.cliente;

import com.tienda.facturas.dominio.modelo.dto.ProductoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(name = "productos-service")
@RequestMapping(value = "/productos")
public interface ProductosCliente {
    @GetMapping(value = "/{id}")
    public ProductoDto consultarPorId(@PathVariable Long id);

    @GetMapping(value = "/categoria/{id}")
    public List<ProductoDto> consultarPorCategoria(@PathVariable Long id);
}
