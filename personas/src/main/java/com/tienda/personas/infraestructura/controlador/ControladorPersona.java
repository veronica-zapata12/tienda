package com.tienda.personas.infraestructura.controlador;

import com.tienda.personas.aplicacion.comando.ComandoPersona;
import com.tienda.personas.aplicacion.comando.manejador.ManejadorCrearPersona;
import com.tienda.personas.aplicacion.consulta.ManejadorConsultaPersonaPorId;
import com.tienda.personas.aplicacion.consulta.ManejadorConsultarPersonas;
import com.tienda.personas.dominio.modelo.dto.PersonasDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personas")
public class ControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorConsultaPersonaPorId manejadorConsultaPersonaPorId;
    private final ManejadorConsultarPersonas manejadorConsultarPersonas;

    public ControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorConsultaPersonaPorId manejadorConsultaPersonaPorId, ManejadorConsultarPersonas manejadorConsultarPersonas) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorConsultaPersonaPorId = manejadorConsultaPersonaPorId;
        this.manejadorConsultarPersonas = manejadorConsultarPersonas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody  ComandoPersona  comandoPersona){
        this.manejadorCrearPersona.ejecutar(comandoPersona);

    }
    @GetMapping(value = "/{id}")
    public PersonasDto buscarPorId(@PathVariable Long id){
        return this.manejadorConsultaPersonaPorId.ejecutar(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonasDto> listar(){
        return this.manejadorConsultarPersonas.ejecutar();
    }
}
