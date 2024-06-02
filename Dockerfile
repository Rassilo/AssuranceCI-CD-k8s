# Base stage for building all services
FROM jelastic/maven:3.9.5-openjdk-21 AS build

# Set the working directory
WORKDIR /app

# Copy the main pom.xml and module pom.xml files to resolve dependencies
COPY pom.xml ./
COPY api-gateway/pom.xml ./api-gateway/
COPY Authenticator-Service/pom.xml ./Authenticator-Service/
COPY Contrat-Service/pom.xml ./Contrat-Service/
COPY eureka-discovery-service/pom.xml ./eureka-discovery-service/
COPY Souscription-assurance-Service/pom.xml ./Souscription-assurance-Service/

# Download the dependencies for each module
RUN mvn dependency:go-offline -B

# Copy the rest of the project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Stage for API-GATEWAY
FROM build AS api-gateway
WORKDIR /app
COPY --from=build /app/api-gateway/target/*.jar app.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage for USER-SERVICE
FROM build AS user-service
WORKDIR /app
COPY --from=build /app/Authenticator-Service/target/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage for ASSURANCE-SERVICE
FROM openjdk:21-slim AS assurance-service
WORKDIR /app
COPY --from=build /app/Souscription-assurance-Service/target/c*.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage for CONTRAT-SERVICE
FROM openjdk:21-slim AS contrat-service
WORKDIR /app
COPY --from=build /app/Contrat-Service/target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage for TYPEASSURANCE-SERVICE
FROM openjdk:21-slim AS typeassurance-service
WORKDIR /app
COPY --from=build /app/TYPEASSURANCE-SERVICE/target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage for EUREKA-DISCOVERY-SERVICE
FROM openjdk:21-slim AS eureka-discovery-service
WORKDIR /app
COPY --from=build /app/eureka-discovery-service/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
