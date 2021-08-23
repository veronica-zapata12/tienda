package com.tienda.productos.dominio.modelo.dto;

import com.tienda.productos.dominio.modelo.dto.CategoriaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDto {
    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;
    private Date creacion;
    private CategoriaDto categoria;


}
