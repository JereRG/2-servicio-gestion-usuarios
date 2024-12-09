
# Estrategia de Pruebas - Microservicio de Gestión de Usuarios

## Niveles de Prueba

### Pruebas Unitarias
**Cobertura objetivo:** 80% mínimo  
**Alcance:**  
- Validaciones de entidades (`PerfilUsuario`, `RelacionesSeguidos`)
- Lógica de servicios
- Mappers y utilidades  
**Herramientas:**  
- Mockito    

### Pruebas de Integración
**Cobertura objetivo:** 70% mínimo  
**Alcance:**  
- Integración con la base de datos MongoDB
- Comunicación entre capas
- Validación de repositorios  
**Herramientas:**  
- TestContainers  
- Spring Boot Test  

### Pruebas de API (E2E)
**Cobertura objetivo:** 90% de endpoints  
**Alcance:**  
- Validación de endpoints REST
- Flujos completos de usuario
- Escenarios de error  
**Herramientas:**  
- REST Assured  
- Postman (colecciones automatizadas)  

## Tipos de Prueba

### Pruebas Funcionales
**Validación de Datos**  
- Formato correcto de `username`
- Longitud válida de `bio`
- URL válida de imagen
- Unicidad de `username`  

**Gestión de Relaciones**  
- Seguir usuario  
- Dejar de seguir usuario  
- Validación de relaciones duplicadas  
- Validación de auto-seguimiento  

**Consultas**  
- Obtención de perfiles  
- Lista de seguidores  
- Lista de seguidos  
- Paginación correcta  

### Pruebas No Funcionales

#### Rendimiento
- Tiempo de respuesta < 200ms para operaciones CRUD
- Tiempo de respuesta < 500ms para consultas complejas
- Pruebas de carga: 1000 usuarios concurrentes  

#### Seguridad
- Validación de tokens JWT
- Protección contra inyección SQL
- Validación de permisos
- Sanitización de datos de entrada  

#### Escalabilidad
- Pruebas con grandes volúmenes de datos
- Comportamiento con cache
- Gestión de conexiones a la base de datos  

