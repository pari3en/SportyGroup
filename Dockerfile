# ---------- BUILD STAGE ----------
FROM gradle:8.6-jdk21 AS builder

WORKDIR /app

# Copy Gradle project files
COPY . .

# Generate gradle wrapper if it doesn't exist
RUN gradle wrapper --no-daemon

# Now use the wrapper
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar --no-daemon

# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy built JAR from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]