FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/request-docker.jar request-docker.jar
ENTRYPOINT ["java", "-jar", "/request-docker.jar"]