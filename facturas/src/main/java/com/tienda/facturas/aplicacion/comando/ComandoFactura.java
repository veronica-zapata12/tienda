package com.tienda.facturas.aplicacion.comando;

import com.tienda.facturas.dominio.modelo.entidad.DetalleFactura;
import lombok.Getter;


import java.util.List;
@Getter
public class ComandoFactura {
    private Long id;
    private Long personaId;
    private List<DetalleFactura> detalleFactura;

    public ComandoFactura(Long id, Long personaId, List<DetalleFactura> detalleFactura) {
        this.id = id;
        this.personaId = personaId;
        this.detalleFactura = detalleFactura;
    }
}
