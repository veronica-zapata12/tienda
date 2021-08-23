package com.tienda.facturas.infraestructura.adaptador.repositorio.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "facturas")
@Getter
@Setter
@AllArgsConstructor
public class FacturaEntidad {
    @Id
    private Long id;
    @Column(name = "persona_id")
    private Long personaId;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalles_id")
    private List<DetallesFacturaEntidad> detallesFacturas;

    private Double total;

    public FacturaEntidad() {
        detallesFacturas=new ArrayList<>();
    }
}
