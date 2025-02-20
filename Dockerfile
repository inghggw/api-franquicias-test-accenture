# Imagen base con JDK 23y Gradle
FROM gradle:8.12.1-jdk23 as builder

# Configurar directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Compilar la aplicación
RUN ./gradlew clean build --no-daemon

# Ejecución con Eclipse Temurin (Java 23)
FROM eclipse-temurin:23

# Copiar la aplicación compilada desde el builder
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Exponer el puerto
EXPOSE 8033

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
