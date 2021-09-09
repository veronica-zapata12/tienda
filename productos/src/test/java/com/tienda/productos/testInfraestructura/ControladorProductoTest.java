package com.tienda.productos.testInfraestructura;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.productos.ProductosApplication;
import com.tienda.productos.aplicacion.comando.ComandoProducto;
import com.tienda.productos.dominio.puerto.repositorio.RepositorioProducto;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.CategoriaEntidad;
import com.tienda.productos.infraestructura.adaptador.repositorio.entidades.ProductoEntidad;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioCategoriaJpa;
import com.tienda.productos.infraestructura.repositorioJpa.RepositorioProductoJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductosApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorProductoTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RepositorioProductoJpa repositorioProductoJpa;
    @Autowired
    private RepositorioCategoriaJpa repositorioCategoriaJpa;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @Transactional
    public void guardarProducto() throws Exception {
        CategoriaEntidad categoriaEntidad=new CategoriaEntidad(1,"zapatos");
        repositorioCategoriaJpa.save(categoriaEntidad);
        ComandoProducto comandoProducto=new ComandoProductoDataBuilder().conNombre("nada123").build();
        mockMvc.perform(post("/productos").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk());

    }
    @Test
    public void consultarPorId() throws Exception {

        mockMvc.perform(get("/productos/{id}", 29)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nada1")))

                .andDo(print());
    }
    @Test
    public void consultarTodos() throws Exception {

        mockMvc.perform(get("/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(20)))
                .andDo(print());
    }
}
