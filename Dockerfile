FROM openjdk:18-jdk-slim
WORKDIR /app
COPY /target/library_system-0.0.1-SNAPSHOT.jar app-library.jar
ENTRYPOINT [ "java", "-jar",  app-library.jar]