package com.fivy.servicio_gestion_usuarios.services;

import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import com.fivy.servicio_gestion_usuarios.repositories.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuario> obtenerTodos() {
        return perfilUsuarioRepository.findAll();
    }

    public Optional<PerfilUsuario> obtenerPorId(String id) {
        return perfilUsuarioRepository.findById(id);
    }

    public PerfilUsuario guardarPerfil(PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    public void eliminarPerfil(String id) {
        perfilUsuarioRepository.deleteById(id);
    }
}