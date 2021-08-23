package com.tienda.facturas.infraestructura.controlador;

import com.tienda.facturas.aplicacion.comando.ComandoFactura;
import com.tienda.facturas.aplicacion.comando.manejador.ManejadorCrearFactura;
import com.tienda.facturas.aplicacion.consulta.ManejadorListarDetallesFactura;
import com.tienda.facturas.aplicacion.consulta.ManejadorListarFacturas;
import com.tienda.facturas.aplicacion.consulta.ManejadorListarFacturasPorId;
import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;
import com.tienda.facturas.dominio.modelo.dto.FacturaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/factura")
public class ControladorFactura {
    private final ManejadorCrearFactura manejadorFactura;
    private final ManejadorListarFacturasPorId manejadorListarFacturasPorId;
    private final ManejadorListarFacturas manejadorListarFacturas;
    private final ManejadorListarDetallesFactura manejadorListarDetallesFactura;

    public ControladorFactura(ManejadorCrearFactura manejadorFactura, ManejadorListarFacturasPorId manejadorListarFacturasPorId, ManejadorListarFacturas manejadorListarFacturas, ManejadorListarDetallesFactura manejadorListarDetallesFactura) {
        this.manejadorFactura = manejadorFactura;
        this.manejadorListarFacturasPorId = manejadorListarFacturasPorId;
        this.manejadorListarFacturas = manejadorListarFacturas;

        this.manejadorListarDetallesFactura = manejadorListarDetallesFactura;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoFactura comandoFactura) {
        this.manejadorFactura.ejecutar(comandoFactura);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<FacturaDto> listarFacturas() {
        return this.manejadorListarFacturas.ejecutar();
    }

    @GetMapping("/{id}")
    public FacturaDto listarPorId(@PathVariable  Long id){

        return this.manejadorListarFacturasPorId.ejecutar(id);
    }

    @GetMapping("/detalles/{id}")
    public List<DetalleFacturaDto> listarDetalles(@PathVariable  Long id){
        return this.manejadorListarDetallesFactura.ejecutar(id);
    }
}
