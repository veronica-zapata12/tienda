package com.tienda.personas.infraestructura.configuracion;

import com.tienda.personas.dominio.puerto.dao.DaoPersonas;
import com.tienda.personas.dominio.puerto.repositorio.RepositorioPersonas;
import com.tienda.personas.dominio.servicio.ServicioConsultarPersona;
import com.tienda.personas.dominio.servicio.ServicioCrearPersona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersonas repositorioPersonas){
        return new ServicioCrearPersona(repositorioPersonas);
    }

    @Bean
    ServicioConsultarPersona servicioConsultarPersona(DaoPersonas daoPersonas){
        return new ServicioConsultarPersona(daoPersonas);
    }


	

}
