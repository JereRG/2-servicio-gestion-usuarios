package com.fivy.servicio_gestion_usuarios.controllers;

import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import com.fivy.servicio_gestion_usuarios.services.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> obtenerTodos() {
        return ResponseEntity.ok(perfilUsuarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> obtenerPorId(@PathVariable String id) {
        return perfilUsuarioService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PerfilUsuario> crearPerfil(@RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.ok(perfilUsuarioService.guardarPerfil(perfilUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable String id) {
        perfilUsuarioService.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}