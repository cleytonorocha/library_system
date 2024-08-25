FROM eclipse-temurin:21
WORKDIR /app
COPY target/library_system-1.0.0.jar library_system.jar
EXPOSE 8080
ADD "src/main/resources/keystore.p12" .
ENTRYPOINT ["java", "-jar", "library_system.jar"]