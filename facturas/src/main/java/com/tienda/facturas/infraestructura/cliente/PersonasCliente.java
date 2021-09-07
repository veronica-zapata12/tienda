package com.tienda.facturas.infraestructura.cliente;

import com.tienda.facturas.dominio.modelo.dto.PersonasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "personas-service", fallback = PersonasHystrixFallbackFactory.class)

public interface PersonasCliente {
    @GetMapping(value = "/{id}")
    public PersonasDto buscarPorId(@PathVariable Long id);
}
