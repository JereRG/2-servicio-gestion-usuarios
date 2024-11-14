package com.fivy.servicio_gestion_usuarios.integration;

import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import com.fivy.servicio_gestion_usuarios.repositories.PerfilUsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@DataMongoTest
public class PerfilUsuarioIntegrationTest {
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0");

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @BeforeEach
    public void setUp() {
        perfilUsuarioRepository.deleteAll();
    }

    @Test
    public void testGuardarYObtenerPerfil() {
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuarioId("12345");
        perfil.setUsername("UsuarioIntegracion");

        perfilUsuarioRepository.save(perfil);

        Optional<PerfilUsuario> encontrado = perfilUsuarioRepository.findById(perfil.getUsuarioId());
        assertTrue(encontrado.isPresent());
        assertEquals("UsuarioIntegracion", encontrado.get().getUsername());
    }
}
