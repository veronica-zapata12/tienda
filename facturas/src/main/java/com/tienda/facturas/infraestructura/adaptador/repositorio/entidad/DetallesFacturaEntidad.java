package com.tienda.facturas.infraestructura.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalles_factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallesFacturaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double cantidad;
    private double precio;
}
