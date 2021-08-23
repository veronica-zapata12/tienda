package com.tienda.facturas.aplicacion.comando.fabrica;

import com.tienda.facturas.aplicacion.comando.ComandoFactura;
import com.tienda.facturas.dominio.modelo.entidad.Factura;
import org.springframework.stereotype.Component;


@Component
public class FabricaFactura {
    public Factura crear(ComandoFactura comandoFactura){
        return new Factura(comandoFactura.getId(), comandoFactura.getPersonaId(), comandoFactura.getDetalleFactura());
    }
}

