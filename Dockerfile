FROM openjdk:8
#-jdk-alpine
#FROM maven:alpine
#RUN mvn clean install -DskipTests
#RUN mvn package docker:build -DskipTests
EXPOSE 8080
ADD ./target/request-docker.jar request-docker.jar
ENTRYPOINT ["java", "-jar", "/request-docker.jar"]