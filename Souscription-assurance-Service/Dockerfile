# Use the official Maven image to build the project
FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
