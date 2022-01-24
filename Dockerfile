FROM openjdk:8-jre-alpine
LABEL maintainer="marioandreseche@gmail.com"
RUN apk add --no-cache openjdk8
COPY target/backend-0.0.1-SNAPSHOT.jar /opt/lib/spring-encuesta.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/spring-encuesta.jar"]
EXPOSE 8080
