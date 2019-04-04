FROM openjdk:8
EXPLOSE 8080
ADD target/request-docker.jar request-docker.jar
ENTRYPOINT ["java", "-jar", "request-docker.jar"]