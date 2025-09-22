FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY target/mini-crm-0.0.1-SNAPSHOT.jar mini-crm-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "mini-crm-0.0.1-SNAPSHOT.jar"]