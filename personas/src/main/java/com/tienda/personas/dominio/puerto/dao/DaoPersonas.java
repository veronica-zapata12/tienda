package com.tienda.personas.dominio.puerto.dao;

import com.tienda.personas.dominio.modelo.dto.PersonasDto;


import java.util.List;

public interface DaoPersonas {
    PersonasDto buscarPorId(Long id);
    List<PersonasDto> listarPersonas();
}
