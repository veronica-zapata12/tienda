package com.tienda.facturas.infraestructura.adaptador.dao;

import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;

import com.tienda.facturas.dominio.puerto.dao.DetallesFacturaDao;
import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.DetallesFacturaEntidad;
import com.tienda.facturas.infraestructura.repositorioJpa.DetallesFacturaRespositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DetallesFacturaDaoPostgres implements DetallesFacturaDao {
    private ModelMapper modelMapper = new ModelMapper();
    private final DetallesFacturaRespositorioJpa detallesFacturaRespositorioJpa;


    public DetallesFacturaDaoPostgres(DetallesFacturaRespositorioJpa detallesFacturaRespositorioJpa) {
        this.detallesFacturaRespositorioJpa = detallesFacturaRespositorioJpa;
        ;
    }


    @Override
    public List<DetalleFacturaDto> buscarFactura(Long id) {
        List<DetallesFacturaEntidad> detalleFacturaEntitylist= detallesFacturaRespositorioJpa.buscarfacturaporid(id);
        List<DetalleFacturaDto> detallefacturaDtoList = new ArrayList<>();
        for( DetallesFacturaEntidad detalleFacturaEntity : detalleFacturaEntitylist ) {
            DetalleFacturaDto detallefacturaDto = modelMapper.map(detalleFacturaEntity, DetalleFacturaDto.class);
            detallefacturaDtoList.add(detallefacturaDto);
        }
        return detallefacturaDtoList;
    }

}
