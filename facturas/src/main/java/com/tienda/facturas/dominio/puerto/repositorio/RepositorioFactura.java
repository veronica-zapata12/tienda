package com.tienda.facturas.dominio.puerto.repositorio;

import com.tienda.facturas.dominio.modelo.entidad.Factura;

public interface RepositorioFactura {
    void crear(Factura factura);
    boolean existe(Factura factura);
}
