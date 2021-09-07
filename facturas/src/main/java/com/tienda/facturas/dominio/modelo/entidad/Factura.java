package com.tienda.facturas.dominio.modelo.entidad;

import lombok.Getter;

import java.util.Date;
import java.util.List;
@Getter
public class Factura {
    private Long id;
    private Long personaId;
    private Date fecha;
    private List<DetalleFactura> detalleFactura;
    private Double total=0.0;
    private Personas personas;

    public Factura(Long id, Long personaId, List<DetalleFactura> detalleFactura) {

        this.id = id;
        this.personaId = personaId;
        this.detalleFactura = detalleFactura;
        this.fecha=new Date();
        this.total=calcularTotal();

    }

    public Double calcularTotal(){
        for (DetalleFactura detalleFactura : detalleFactura) {
            this.total += detalleFactura.calcularParcial();
        }
        return this.total;
    }

}
