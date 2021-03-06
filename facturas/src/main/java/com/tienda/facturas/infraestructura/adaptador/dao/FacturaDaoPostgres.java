package com.tienda.facturas.infraestructura.adaptador.dao;

import com.tienda.facturas.dominio.modelo.dto.DetalleFacturaDto;
import com.tienda.facturas.dominio.modelo.dto.FacturaDto;
import com.tienda.facturas.dominio.modelo.dto.PersonasDto;
import com.tienda.facturas.dominio.modelo.dto.ProductoDto;
import com.tienda.facturas.dominio.puerto.dao.FacturaDao;
import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.DetallesFacturaEntidad;
import com.tienda.facturas.infraestructura.adaptador.repositorio.entidad.FacturaEntidad;
import com.tienda.facturas.infraestructura.cliente.PersonasCliente;
import com.tienda.facturas.infraestructura.cliente.ProductosCliente;
import com.tienda.facturas.infraestructura.repositorioJpa.RepositorioFacturaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class FacturaDaoPostgres implements FacturaDao {
    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioFacturaJpa repositorioFacturaJpa;
    private final DetallesFacturaDaoPostgres detallesFacturaDaoPostgres;

    @Autowired
    PersonasCliente personasCliente;

    public FacturaDaoPostgres(RepositorioFacturaJpa repositorioFacturaJpa, DetallesFacturaDaoPostgres detallesFacturaDaoPostgres) {
        this.repositorioFacturaJpa = repositorioFacturaJpa;
        this.detallesFacturaDaoPostgres = detallesFacturaDaoPostgres;
    }

    @Override
    public FacturaDto buscarPorId(Long id) {
       FacturaEntidad facturaEntidad=repositorioFacturaJpa.buscarporid(id);

       List<DetalleFacturaDto>detalleFacturaDtos=new ArrayList<>();
       FacturaDto facturaDto=modelMapper.map(facturaEntidad,FacturaDto.class);
        if(null != facturaEntidad){
            PersonasDto personaDto=  personasCliente.buscarPorId(facturaEntidad.getPersonaId());
            facturaDto.setPersona(personaDto);
        }
       for (DetallesFacturaEntidad detallesFacturaEntidad:facturaEntidad.getDetallesFacturas()){
          DetalleFacturaDto detalleFacturaDto=modelMapper.map(detallesFacturaEntidad,DetalleFacturaDto.class);
          detalleFacturaDtos.add(detalleFacturaDto);
       }
       facturaDto.setDetalleFacturaDtos(detalleFacturaDtos);

        return facturaDto;
    }

    @Override
    public List<FacturaDto> listarTodos() {
        List<FacturaEntidad> facturaEntidadList= repositorioFacturaJpa.findAll();
        List<FacturaDto> facturaDtoList=new ArrayList<>();
        List<DetalleFacturaDto> detallesFactura= new ArrayList<>();
        for(FacturaEntidad facturaEntidad:facturaEntidadList){
           detallesFactura= detallesFacturaDaoPostgres.buscarFactura(facturaEntidad.getId());
           PersonasDto  personasDto=personasCliente.buscarPorId(facturaEntidad.getPersonaId());
            FacturaDto facturaDto=modelMapper.map(facturaEntidad,FacturaDto.class);
            facturaDto.setDetalleFacturaDtos(detallesFactura);
            facturaDto.setPersona(personasDto);
            facturaDtoList.add(facturaDto);
        }
        return facturaDtoList;
    }
}
