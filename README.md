
# Microservicio de Gestión de Usuarios

Este microservicio forma parte de una red social desarrollada en Java con Spring Boot, basada en una arquitectura de microservicios. El microservicio de Gestión de Usuarios se encarga de manejar la información relacionada con los perfiles de los usuarios, así como las relaciones de seguimiento entre ellos.

## Tabla de Contenidos
1. [Descripción General](#descripción-general)
2. [Requisitos Previos](#requisitos-previos)
3. [Instalación](#instalación)
4. [Configuración](#configuración)
5. [Dependencias](#dependencias)
6. [Estructura del Proyecto](#estructura-del-proyecto)
7. [Modelos de Datos](#modelos-de-datos)
8. [Servicios](#servicios)
9. [Controladores](#controladores)
10. [Pruebas](#pruebas)

## Descripción General
El microservicio de Gestión de Usuarios se centra en administrar la información básica de los perfiles de los usuarios y las relaciones de seguimiento. Esto incluye crear y gestionar perfiles, manejar la lista de seguidores y seguidos, y proporcionar datos relevantes a otros microservicios.

## Requisitos Previos
- Java 17 o superior
- Maven 3.6 o superior
- MongoDB
- Spring Boot 3.3.5

## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/JereRG/2-servicio-gestion-usuarios
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd 2-servicio-gestion-usuarios
   ```
3. Construye el proyecto usando Maven:
   ```bash
   mvn clean install
   ```
4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Configuración
La configuración de la conexión a MongoDB se realiza en el archivo `application.properties` o `application.yml` ubicado en el directorio `src/main/resources`. Asegúrate de que tu configuración de MongoDB sea correcta:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/gestion-usuarios
```

## Dependencias
El proyecto utiliza las siguientes dependencias principales:
- `spring-boot-starter-data-mongodb`: Para interactuar con MongoDB.
- `spring-boot-starter-web`: Para construir servicios RESTful.
- `spring-boot-devtools`: Para desarrollo ágil.
- `spring-boot-starter-test`: Para pruebas.

## Estructura del Proyecto
```
servicio-gestion-usuarios/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tu_organizacion/
│   │   │           └── gestionusuarios/
│   │   │               ├── controllers/
│   │   │               ├── models/
│   │   │               ├── repositories/
│   │   │               └── services/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
├── pom.xml
└── README.md
```

## Modelos de Datos
### PerfilUsuario
```java
public class PerfilUsuario {
    private String id; // Referencia al usuario
    private String username; // Nombre visible
    private String bio; // Descripción personal
    private String imageUrl; // URL de la foto de perfil
    private List<String> publicaciones; // Referencia a publicaciones
}
```
### RelacionesSeguidos
```java
public class RelacionesSeguidos {
    private String id;
    private String followerId; // Usuario que sigue
    private String followingId; // Usuario seguido
}
```

## Servicios
Los servicios proporcionan la lógica de negocio para gestionar las operaciones sobre los datos del usuario y las relaciones de seguimiento.

## Controladores
Los controladores exponen endpoints RESTful para interactuar con el microservicio.

## Pruebas
Las pruebas se encuentran en el directorio `src/test/java` y utilizan `spring-boot-starter-test` para ejecutar pruebas unitarias e integradas.
