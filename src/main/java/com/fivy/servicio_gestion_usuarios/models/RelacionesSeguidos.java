package com.fivy.servicio_gestion_usuarios.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="relaciones_seguidos")

public class RelacionesSeguidos {
    @Id
    private String id; //ID generado por mongoDB

    private String followerId; // ID del usuario que sigue
    private String followingId; // ID del usuario seguido
    
}
