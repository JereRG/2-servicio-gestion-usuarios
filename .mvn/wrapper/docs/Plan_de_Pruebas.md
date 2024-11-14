
# Plan de Pruebas - Microservicio de Gestión de Usuarios

## Objetivo
El objetivo del Plan de Pruebas es asegurar la correcta funcionalidad, rendimiento y seguridad del microservicio de Gestión de Usuarios. Se validarán las operaciones clave, incluyendo la creación, actualización y eliminación de perfiles, así como la gestión de relaciones de seguimiento entre usuarios.

## Casos de Prueba Detallados

### Creación de Perfil

**Caso 1:** Crear un perfil con todos los campos obligatorios rellenados correctamente.  
**Pasos:**  
- Enviar una solicitud POST al endpoint de creación de perfil con datos válidos.  
**Validación:**  
- Verificar que se haya creado un nuevo registro en la base de datos con los datos correctos.

**Caso 2:** Intentar crear un perfil con un username duplicado.  
**Pasos:**  
- Enviar una solicitud POST con un username que ya existe en la base de datos.  
**Validación:**  
- Verificar que se devuelva un error indicando que el username ya está en uso.

**Caso 3:** Intentar crear un perfil con un campo obligatorio vacío o con un formato incorrecto.  
**Pasos:**  
- Enviar solicitudes POST con datos faltantes o con formatos inválidos (por ejemplo, un correo electrónico mal formado).  
**Validación:**  
- Verificar que se devuelva un error indicando el campo inválido.

### Actualización de Perfil

**Caso 1:** Actualizar el username, biografía e imagen de perfil.  
**Pasos:**  
- Enviar una solicitud PUT al endpoint de actualización de perfil con los nuevos datos.  
**Validación:**  
- Verificar que los datos en la base de datos se hayan actualizado correctamente.

**Caso 2:** Intentar actualizar el username a uno que ya existe.  
**Pasos:**  
- Enviar una solicitud PUT con un nuevo username que ya está en uso.  
**Validación:**  
- Verificar que se devuelva un error indicando que el username ya está en uso.

**Caso 3:** Intentar actualizar un perfil que no existe.  
**Pasos:**  
- Enviar una solicitud PUT a un ID de usuario inexistente.  
**Validación:**  
- Verificar que se devuelva un error indicando que el perfil no se encontró.

### Seguimiento de Usuarios

**Caso 1:** Seguir a otro usuario existente.  
**Pasos:**  
- Enviar una solicitud POST al endpoint de seguimiento con los IDs de usuario del seguidor y el seguido.  
**Validación:**  
- Verificar que se haya creado una nueva relación de seguimiento en la base de datos.

**Caso 2:** Dejar de seguir a un usuario.  
**Pasos:**  
- Enviar una solicitud DELETE al endpoint de seguimiento con los IDs de usuario.  
**Validación:**  
- Verificar que se haya eliminado la relación de seguimiento de la base de datos.

**Caso 3:** Intentar seguir a sí mismo.  
**Pasos:**  
- Enviar una solicitud POST con el mismo ID de usuario para el seguidor y el seguido.  
**Validación:**  
- Verificar que se devuelva un error indicando que no se puede seguir a sí mismo.

### Consulta de Perfiles

**Caso 1:** Obtener el perfil de un usuario existente.  
**Pasos:**  
- Enviar una solicitud GET al endpoint de obtención de perfil con el ID del usuario.  
**Validación:**  
- Verificar que se devuelvan los datos del perfil correctamente.

**Caso 2:** Obtener la lista de seguidores de un usuario.  
**Pasos:**  
- Enviar una solicitud GET al endpoint de obtención de seguidores con el ID del usuario.  
**Validación:**  
- Verificar que se devuelva la lista completa de seguidores.

**Caso 3:** Intentar obtener el perfil de un usuario que no existe.  
**Pasos:**  
- Enviar una solicitud GET a un ID de usuario inexistente.  
**Validación:**  
- Verificar que se devuelva un error indicando que el perfil no se encontró.

### Escenarios de Error y Seguridad

- **Autenticación y autorización:** Verificar que solo los usuarios autenticados puedan realizar ciertas acciones y que los permisos estén correctamente configurados.

### Pruebas de Rendimiento

- **Carga:** Simular un gran número de usuarios realizando solicitudes al mismo tiempo.
- **Estrés:** Exponer el sistema a cargas extremas para identificar sus límites.

## Herramientas

- **JUnit:** Para crear y ejecutar casos de prueba.
- **Mockito:** Para simular dependencias.
- **Herramienta de cobertura de código:** Para medir la cobertura de código.
- **Herramienta de base de datos:** Para verificar los datos en la base de datos.
- **Herramienta de rendimiento:** Para medir el rendimiento del sistema.

