FROM adoptopenjdk/openjdk11:alpine-jre
ENV APP_HOME=/app/
WORKDIR $APP_HOME
COPY target/springboot_activemq-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]