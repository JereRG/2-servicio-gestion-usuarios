package com.fivy.servicio_gestion_usuarios.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "perfiles_usuarios")
public class PerfilUsuario {
    
    @Id
    private String id; // Id relacionada con el id del usuario microservicio 1
    private String usuarioId;
    private String username;
    private String bio;
    private String imageUrl;
    private List<String> publicacionesIds; // Lista de IDs para referenciar publicaciones (traerlo de el microservicio de publicaciones o nose)
}