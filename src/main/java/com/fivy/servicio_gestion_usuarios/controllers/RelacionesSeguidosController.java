package com.fivy.servicio_gestion_usuarios.controllers;

import com.fivy.servicio_gestion_usuarios.models.RelacionesSeguidos;
import com.fivy.servicio_gestion_usuarios.services.RelacionesSeguidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relaciones")
public class RelacionesSeguidosController {
    @Autowired
    private RelacionesSeguidosService relacionesSeguidosService;

    
    @GetMapping("/seguidores/{followingId}")
    public ResponseEntity<List<RelacionesSeguidos>> obtenerSeguidores(@PathVariable String followingId) {
        return ResponseEntity.ok(relacionesSeguidosService.obtenerSeguidores(followingId));
    }

    
    @GetMapping("/seguidos/{followerId}")
    public ResponseEntity<List<RelacionesSeguidos>> obtenerSeguidos(@PathVariable String followerId) {
        return ResponseEntity.ok(relacionesSeguidosService.obtenerSeguidos(followerId));
    }

    
    @PostMapping
    public ResponseEntity<RelacionesSeguidos> crearRelacion(@RequestBody RelacionesSeguidos relacion) {
        return ResponseEntity.ok(relacionesSeguidosService.crearRelacion(relacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable String id) {
        relacionesSeguidosService.eliminarRelacion(id);
        return ResponseEntity.noContent().build();
    }
}
