# Etapa 1: Construir el .jar con Maven y Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Compilar sin correr pruebas
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecutar el .jar
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el .jar generado desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
