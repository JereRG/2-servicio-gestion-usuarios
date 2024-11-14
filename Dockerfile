# Usa una imagen de base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/servicio-gestion-usuarios-1.0.0.jar app.jar

# Expone el puerto en el que se ejecuta tu aplicación (e.g., 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
