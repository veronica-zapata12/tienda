package com.tienda.productos.aplicacion.consulta;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import com.tienda.productos.dominio.servicio.ServicioConsultarCategorias;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaCategorias {
    private final ServicioConsultarCategorias servicioConsultarCategorias;

    public ManejadorConsultaCategorias(ServicioConsultarCategorias servicioConsultarCategorias) {
        this.servicioConsultarCategorias = servicioConsultarCategorias;
    }
    public List<CategoriaDto>ejecutar(){
        return servicioConsultarCategorias.listarTodasCategorias();
    }
}
