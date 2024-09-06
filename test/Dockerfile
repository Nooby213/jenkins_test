# Stage 1: Build stage
FROM openjdk:17-jdk-alpine AS build

# Set working directory
WORKDIR /app

# Copy the Gradle wrapper and project files
COPY . .

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew build

# Stage 2: Production stage
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy only the built jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port on which the app will run
EXPOSE 8000

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
