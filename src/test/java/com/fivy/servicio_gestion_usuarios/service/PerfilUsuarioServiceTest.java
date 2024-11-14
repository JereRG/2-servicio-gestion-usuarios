package com.fivy.servicio_gestion_usuarios.service;

import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import com.fivy.servicio_gestion_usuarios.repositories.PerfilUsuarioRepository;
import com.fivy.servicio_gestion_usuarios.services.PerfilUsuarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PerfilUsuarioServiceTest {
    @InjectMocks
    private PerfilUsuarioService perfilUsuarioService;

    @Mock
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Test
    public void testGuardarPerfil() {
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuarioId("12345");
        perfil.setUsername("UsuarioTest");

        when(perfilUsuarioRepository.save(any(PerfilUsuario.class))).thenReturn(perfil);

        PerfilUsuario resultado = perfilUsuarioService.guardarPerfil(perfil);
        assertNotNull(resultado);
        assertEquals("UsuarioTest", resultado.getUsername());
        verify(perfilUsuarioRepository, times(1)).save(perfil);
    }

    @Test
    public void testObtenerPorId() {
        String usuarioId = "12345";
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuarioId(usuarioId);

        when(perfilUsuarioRepository.findById(usuarioId)).thenReturn(Optional.of(perfil));

        Optional<PerfilUsuario> resultado = perfilUsuarioService.obtenerPorId(usuarioId);
        assertTrue(resultado.isPresent());
        assertEquals(usuarioId, resultado.get().getUsuarioId());
    }
}
