package com.tienda.productos.testDominio;

import com.tienda.productos.dominio.modelo.entidad.Categoria;

import javax.persistence.Id;
import java.util.Calendar;

public class CategoriaDataBuilder {
    private static final Long ID=1l;
    private static final String NOMBRE="zapatos";
    private long id;

    private String nombre;

    public CategoriaDataBuilder() {
        this.id= ID;
        this.nombre=NOMBRE;
    }
    public  Categoria build(){
        return new Categoria(this.id,this.nombre);
    }
}
