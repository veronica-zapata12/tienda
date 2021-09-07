package com.tienda.facturas.dominio.modelo.dto;

import com.tienda.facturas.dominio.modelo.entidad.Personas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class DetalleFacturaDto {
    private Long id;
    private Double cantidad;
    private double precio;


    public DetalleFacturaDto(Long id, Double cantidad, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
