package com.tienda.facturas.dominio.servicio;

import com.tienda.facturas.dominio.excepcion.ExcepcionDuplicidad;
import com.tienda.facturas.dominio.modelo.entidad.Factura;
import com.tienda.facturas.dominio.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {
    private static final String LA_FACTURA_YA_EXISTE="la factura ya existe en el sistema";
    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }
    public void ejecutar(Factura factura) {
        validarExistenciaPrevia(factura);
        this.repositorioFactura.crear(factura);
    }
    private void validarExistenciaPrevia(Factura factura){
        boolean existe=this.repositorioFactura.existe(factura);
        if (existe){
            throw new ExcepcionDuplicidad(LA_FACTURA_YA_EXISTE);
        }
    }
}
