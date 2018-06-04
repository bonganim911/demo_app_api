FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-data-0.0.1-SNAPSHOT.jar"]