FROM openjdk:11.0.5-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-envio-email.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/api-envio-email.jar"]