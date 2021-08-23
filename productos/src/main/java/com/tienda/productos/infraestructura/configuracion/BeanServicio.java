package com.tienda.productos.infraestructura.configuracion;

import com.tienda.productos.dominio.puerto.dao.DaoCategoria;
import com.tienda.productos.dominio.puerto.dao.DaoProducto;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;
import com.tienda.productos.dominio.servicio.ServicioCrearProducto;
import com.tienda.productos.dominio.servicio.ServicioListarProductos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearProducto  servicioCrearProducto (RepositorioProducto repositorioProducto, DaoCategoria daoCategoria) {
        return new ServicioCrearProducto(repositorioProducto,daoCategoria);
    }

    @Bean
    public ServicioListarProductos servicioListarProductos (DaoProducto daoProducto) {
        return new ServicioListarProductos(daoProducto);
    }


	

}
