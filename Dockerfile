FROM eclipse-temurin:17
WORKDIR /app
COPY target/library_system-1.0.0.jar library_system.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "library_system.jar"]