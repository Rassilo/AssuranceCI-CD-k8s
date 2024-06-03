# Stage 1: Build dependencies
FROM jelastic/maven:3.9.5-openjdk-21 AS dependencies

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

# Stage 2: Build all services
FROM jelastic/maven:3.9.5-openjdk-21 AS build

WORKDIR /app

# Copy the entire project
COPY . .

# Use the cached dependencies from the previous stage
COPY --from=dependencies /root/.m2 /root/.m2

# Build the project
RUN mvn clean package -DskipTests

# Stage 3: Create the final images for each service
# API-GATEWAY
FROM jelastic/maven:3.9.5-openjdk-21 AS api-gateway
WORKDIR /app
COPY --from=build /app/api-gateway/target/*.jar app.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "app.jar"]

# USER-SERVICE
FROM jelastic/maven:3.9.5-openjdk-21 AS user-service
WORKDIR /app
COPY --from=build /app/Authenticator-Service/target/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]

# ASSURANCE-SERVICE
FROM jelastic/maven:3.9.5-openjdk-21 AS assurance-service
WORKDIR /app
COPY --from=build /app/Souscription-assurance-Service/target/*.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]

# CONTRAT-SERVICE
FROM jelastic/maven:3.9.5-openjdk-21 AS contrat-service
WORKDIR /app
COPY --from=build /app/Contrat-Service/target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "app.jar"]

# TYPEASSURANCE-SERVICE
FROM jelastic/maven:3.9.5-openjdk-21 AS typeassurance-service
WORKDIR /app
COPY --from=build /app/TYPEASSURANCE-SERVICE/target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]

# EUREKA-DISCOVERY-SERVICE
FROM jelastic/maven:3.9.5-openjdk-21 AS eureka-discovery-service
WORKDIR /app
COPY --from=build /app/eureka-discovery-service/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
