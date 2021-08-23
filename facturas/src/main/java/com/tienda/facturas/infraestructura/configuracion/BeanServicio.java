package com.tienda.facturas.infraestructura.configuracion;

import com.tienda.facturas.dominio.puerto.dao.DetallesFacturaDao;
import com.tienda.facturas.dominio.puerto.dao.FacturaDao;
import com.tienda.facturas.dominio.puerto.repositorio.RepositorioFactura;
import com.tienda.facturas.dominio.servicio.ServicioCrearFactura;

import com.tienda.facturas.dominio.servicio.ServicioListarDetallesFactura;
import com.tienda.facturas.dominio.servicio.ServicioListarFacturas;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearFactura servicioCrearFactura( RepositorioFactura repositorioFactura){
        return new ServicioCrearFactura(repositorioFactura);
    }
    @Bean
    public ServicioListarFacturas  servicioListarFacturas(FacturaDao facturaDao){
        return new ServicioListarFacturas(facturaDao);
    }
    @Bean
    public ServicioListarDetallesFactura servicioListarDetallesFactura(DetallesFacturaDao detallesFacturaDao){
        return new ServicioListarDetallesFactura(detallesFacturaDao);
    }

}
