package com.tienda.facturas.dominio.modelo.dto;



import com.tienda.facturas.dominio.modelo.entidad.Personas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class FacturaDto {
    private Long id;
    private Long personaId;
    private Date fecha;
    private PersonasDto persona;
    private List<DetalleFacturaDto> detalleFacturaDtos;
    private Double total=0.0;



    public FacturaDto(Long id, Long personaId, List<DetalleFacturaDto> detalleFacturaDtos) {
        this.id = id;
        this.personaId = personaId;
        this.detalleFacturaDtos = detalleFacturaDtos;
    }
}
