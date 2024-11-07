package com.fivy.servicio_gestion_usuarios.repositories;

import com.fivy.servicio_gestion_usuarios.models.PerfilUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerfilUsuarioRepository extends MongoRepository<PerfilUsuario, String> {
    
}
