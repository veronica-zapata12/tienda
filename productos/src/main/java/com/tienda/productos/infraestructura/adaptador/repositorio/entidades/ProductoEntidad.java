package com.tienda.productos.infraestructura.adaptador.repositorio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private  Double precio;
    private String estado;
    @Temporal(TemporalType.DATE)
    private Date creacion;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name="categoria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private CategoriaEntidad categoriaEntidad;
}
