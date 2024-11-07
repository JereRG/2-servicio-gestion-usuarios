package com.fivy.servicio_gestion_usuarios.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.fivy.servicio_gestion_usuarios.models.RelacionesSeguidos;

public interface RelacionesSeguidosRepository extends MongoRepository<RelacionesSeguidos, String> {

    // Encuentra todas las relaciones donde un usuario sigue a otro
    List<RelacionesSeguidos> findByFollowerId(String followerId);
    // Encuentra todos los seguidores de un usuario
    List<RelacionesSeguidos> findByFollowingId(String followingId);

}
