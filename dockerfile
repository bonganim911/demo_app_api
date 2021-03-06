FROM openjdk:8-jdk-alpine

VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/spring-data-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
 ADD ${JAR_FILE} myapi-demo.jar
 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapi-demo.jar"]
