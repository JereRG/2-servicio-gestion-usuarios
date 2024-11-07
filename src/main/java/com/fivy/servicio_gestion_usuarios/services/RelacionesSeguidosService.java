package com.fivy.servicio_gestion_usuarios.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fivy.servicio_gestion_usuarios.models.RelacionesSeguidos;
import com.fivy.servicio_gestion_usuarios.repositories.RelacionesSeguidosRepository;

@Service
public class RelacionesSeguidosService {
    
    @Autowired
     private RelacionesSeguidosRepository relacionesSeguidosRepository;

     public List<RelacionesSeguidos> obtenerSeguidores(String followingId) {
        return relacionesSeguidosRepository.findByFollowingId(followingId);
    }

    public List<RelacionesSeguidos> obtenerSeguidos(String followerId) {
        return relacionesSeguidosRepository.findByFollowerId(followerId);
    }

    public RelacionesSeguidos crearRelacion(RelacionesSeguidos relacion) {
        return relacionesSeguidosRepository.save(relacion);
    }

    public void eliminarRelacion(String id) {
        relacionesSeguidosRepository.deleteById(id);
    }

    public List<RelacionesSeguidos> getRelacionesByFollowerId(String followerId) {
        return relacionesSeguidosRepository.findByFollowerId(followerId);
    }

    public List<RelacionesSeguidos> getRelacionesByFollowingId(String followingId) {
        return relacionesSeguidosRepository.findByFollowingId(followingId);
    }   
}
