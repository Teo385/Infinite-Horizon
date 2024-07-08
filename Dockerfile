# Utiliza una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Define el argumento para el nombre del archivo JAR
ARG JAR_FILE=target/prueba-0.0.1-SNAPSHOT.jar

# Copia el archivo JAR de tu aplicación al contenedor
COPY ${JAR_FILE} /app/infinite_Horizon.jar

# Expone el puerto que usa tu aplicación
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "/app/infinite_Horizon.jar"]
