package com.fivy.servicio_gestion_usuarios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import com.fivy.servicio_gestion_usuarios.services.PerfilUsuarioService;
import com.fivy.servicio_gestion_usuarios.controllers.PerfilUsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PerfilUsuarioController.class)
public class PerfilUsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PerfilUsuarioService perfilUsuarioService;

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos a JSON

    @Test
    public void testObtenerTodos() throws Exception {
        PerfilUsuario perfil1 = new PerfilUsuario();
        perfil1.setUsuarioId("123");
        perfil1.setUsername("Usuario1");

        PerfilUsuario perfil2 = new PerfilUsuario();
        perfil2.setUsuarioId("456");
        perfil2.setUsername("Usuario2");

        when(perfilUsuarioService.obtenerTodos()).thenReturn(Arrays.asList(perfil1, perfil2));

        mockMvc.perform(get("/api/perfiles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("Usuario1"))
                .andExpect(jsonPath("$[1].username").value("Usuario2"));
    }

    @Test
    public void testObtenerPorId() throws Exception {
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuarioId("123");
        perfil.setUsername("UsuarioTest");

        when(perfilUsuarioService.obtenerPorId("123")).thenReturn(Optional.of(perfil));

        mockMvc.perform(get("/api/perfiles/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("UsuarioTest"));
    }

    @Test
    public void testCrearPerfil() throws Exception {
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuarioId("123");
        perfil.setUsername("NuevoUsuario");

        when(perfilUsuarioService.guardarPerfil(any(PerfilUsuario.class))).thenReturn(perfil);

        mockMvc.perform(post("/api/perfiles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfil)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("NuevoUsuario"));
    }
}
