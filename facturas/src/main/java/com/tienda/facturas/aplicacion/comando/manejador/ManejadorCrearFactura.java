package com.tienda.facturas.aplicacion.comando.manejador;

import com.tienda.facturas.aplicacion.comando.ComandoFactura;
import com.tienda.facturas.aplicacion.comando.fabrica.FabricaFactura;
import com.tienda.facturas.dominio.modelo.entidad.Factura;
import com.tienda.facturas.dominio.servicio.ServicioCrearFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura {
    private final ServicioCrearFactura servicioCrearFactura;
    private final FabricaFactura fabricaFactura;

    public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaFactura fabricaFactura) {
        this.servicioCrearFactura = servicioCrearFactura;
        this.fabricaFactura = fabricaFactura;
    }

    public void ejecutar(ComandoFactura comandoFactura) {
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        this.servicioCrearFactura.ejecutar(factura);
    }
}
