package com.tienda.facturas.infraestructura.cliente;

import com.tienda.facturas.dominio.modelo.dto.PersonasDto;

public class PersonasHystrixFallbackFactory implements  PersonasCliente{
    @Override
    public PersonasDto buscarPorId(Long id) {
        PersonasDto personasDto= new PersonasDto(null,"none");
        return personasDto;
    }
}
