package com.tienda.facturas.infraestructura.adaptador.repositorio;


import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;
import com.tienda.facturas.dominio.modelo.entidad.DetalleFactura;
import com.tienda.facturas.dominio.modelo.entidad.Factura;
import com.tienda.facturas.dominio.puerto.repositorio.RepositorioFactura;
import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.DetallesFacturaEntidad;
import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.FacturaEntidad;
import com.tienda.facturas.infraestructura.repositorioJpa.RepositorioFacturaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioFacturaPostgres implements RepositorioFactura {
    private ModelMapper modelMapper=new ModelMapper();
    private final RepositorioFacturaJpa repositorioFacturaJpa;


    public RepositorioFacturaPostgres(RepositorioFacturaJpa repositorioFacturaJpa) {
        this.repositorioFacturaJpa = repositorioFacturaJpa;

    }

    @Override
    public void crear(Factura factura) {
        List<DetalleFactura> detalleFactura1 =factura.getDetalleFactura();
        List<DetallesFacturaEntidad> detalleFacturaEntitiesEmergente = new ArrayList<>();

        FacturaEntidad facturaEntidad=modelMapper.map(factura,FacturaEntidad.class);
        for (DetalleFactura detalleFactura: detalleFactura1){
            DetallesFacturaEntidad detallesFacturaEntidad=modelMapper.map(detalleFactura,DetallesFacturaEntidad.class);
            detalleFacturaEntitiesEmergente.add(detallesFacturaEntidad);
        }
        facturaEntidad.setDetallesFacturas(detalleFacturaEntitiesEmergente);
        repositorioFacturaJpa.save(facturaEntidad);

    }

    @Override
    public boolean existe(Factura factura) {
        Long id=factura.getId();
        return (repositorioFacturaJpa.buscarporid(id))!= null ? true : false;
    }
}
