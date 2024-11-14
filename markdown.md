# Arquitectura del Proyecto

El proyecto se encuentra organizado en carpetas que dividen las distintas funciones del código:

- **.mvn**: Contiene la configuración de Maven Wrapper, que especifica la versión del wrapper y la URL de distribución.
  
- **src/main/java/com/fivy/servicio_gestion_usuario**: Alberga el código fuente principal del microservicio.
  - **controllers**: Define los controladores que manejan las solicitudes a la API REST.
  - **models**: Define los modelos de datos para las entidades del sistema.
  - **repositories**: Define los repositorios que interactúan con la base de datos MongoDB.
  - **services**: Define los servicios que contienen la lógica de negocio.

- **src/main/resources**: Contiene la configuración del microservicio y los recursos estáticos.
  - **application.properties**: Define propiedades como la conexión a MongoDB y el nombre de la aplicación.
  - **static**: Directorio para archivos estáticos como CSS.
  - **templates**: Directorio para plantillas HTML.

- **src/test/java/com/fivy/servicio_gestion_usuarios**: Contiene las pruebas unitarias del microservicio.
  - **controller**: Pruebas para los controladores.
  - **service**: Pruebas para los servicios.

- **target**: Contiene los archivos compilados y generados durante la creacióndel proyecto.

## Componentes del Microservicio

### Controladores
Los controladores sirven como intermediarios entre las solicitudes HTTP y la lógica de negocio del microservicio.

- **PerfilUsuarioController**:
  - `obtenerTodos()`: Recupera todos los perfiles de usuario.
  - `obtenerPorId(String id)`: Recupera un perfil de usuario por su ID.
  - `crearPerfil(PerfilUsuario perfilUsuario)`: Crea un nuevo perfil de usuario.
  - `eliminarPerfil(String id)`: Elimina un perfil de usuario por su ID.

- **RelacionesSeguidosController**:
  - `obtenerSeguidores(String followingId)`: Recupera los seguidores de un usuario dado su ID.
  - `obtenerSeguidos(String followerId)`: Recupera los usuarios a los que sigue un usuario dado su ID.
  - `crearRelacion(RelacionesSeguidos relacion)`: Crea una nueva relación de seguimiento.
  - `eliminarRelacion(String id)`: Elimina una relación de seguimiento por su ID.

### Servicios
Los servicios implementan la lógica de negocio del microservicio.

- **PerfilUsuarioService**:
  - `obtenerTodos()`: Recupera todos los perfiles de usuario del repositorio.
  - `obtenerPorId(String id)`: Recupera un perfil de usuario por su ID del repositorio.
  - `guardarPerfil(PerfilUsuario perfilUsuario)`: Guarda un nuevo perfil de usuario o actualiza uno existente en el repositorio.
  - `eliminarPerfil(String id)`: Elimina un perfil de usuario por su ID del repositorio.

- **RelacionesSeguidosService**:
  - `obtenerSeguidores(String followingId)`: Recupera los seguidores de un usuario del repositorio.
  - `obtenerSeguidos(String followerId)`: Recupera los usuarios seguidos por un usuario del repositorio.
  - `crearRelacion(RelacionesSeguidos relacion)`: Crea una nueva relación de seguimiento en el repositorio.
  - `eliminarRelacion(String id)`: Elimina una relación de seguimiento del repositorio.
  - `getRelacionesByFollowerId(String followerId)`: Obtiene relaciones de seguimiento por el ID del seguidor.
  - `getRelacionesByFollowingId(String followingId)`: Obtiene relaciones de seguimiento por el ID del usuario seguido.

### Modelos
Los modelos representan las entidades del sistema y sus atributos.

- **PerfilUsuario**:
  - `id`: ID único del perfil.
  - `usuarioId`: ID del usuario en el sistema.
  - `username`: Nombre de usuario.
  - `bio`: Biografía del usuario.
  - `imageUrl`: URL de la imagen de perfil.
  - `publicacionesIds`: Lista de IDs de publicaciones del usuario.

- **RelacionesSeguidos**:
  - `id`: ID único de la relación.
  - `followerId`: ID del usuario seguidor.
  - `followingId`: ID del usuario seguido.

### Repositorios
Los repositorios proporcionan una interfaz para interactuar con la base de datos MongoDB.

- **PerfilUsuarioRepository**: Extiende `MongoRepository` para realizar operaciones CRUD (Creat, read, Update,Delete) en la colección `perfiles_usuarios`.
- **RelacionesSeguidosRepository**: Extiende `MongoRepository` para realizar operaciones CRUD en la colección `relaciones_seguidos` y ofrece métodos para buscar relaciones por `followerId` y `followingId`.

### Otros Componentes
- **ServiceGestionUsuariosApplication**: Clase principal que inicia la aplicación Spring Boot.
- **application.properties**: Define la configuración del microservicio, incluyendo la URI de conexión a MongoDB.
- **pom.xml**: Define las dependencias del proyecto, como Spring Boot, MongoDB, Lombok, etc.
- **Archivos de prueba**: `PerfilUsuarioControllerTest`, `PerfilUsuarioServiceTest`, `ServicioGestionUsuariosApplicationTests`.

## Aspectos Adicionales
- **Lombok**: El código utiliza Lombok para simplificar la escritura de código repetitiva, como getters, setters y constructores.
- **Pruebas Unitarias**: Se implementan pruebas unitarias utilizando JUnit y Mockito para verificar el funcionamiento de los controladores y servicios.
- **Control de Versiones**: Se incluyen archivos para configurar el control de versiones, como `.gitignore` y `.gitattributes`.



