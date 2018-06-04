FROM openjdk:8-jre-alpine
COPY ./target/hola-docker-1.0.0-SNAPSHOT.jar /usr/src/demo_app_api/
WORKDIR /usr/src/main/java/demo
EXPOSE 8080
CMD ["java", "-jar", "spring-data-0.0.1-SNAPSHOT.jar"]