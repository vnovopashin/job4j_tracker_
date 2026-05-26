FROM openjdk:21-ea-1-jdk-slim-buster
WORKDIR /app
COPY /target/tracker-1.0.jar /app/tracker.jar

LABEL authors="nova"

ENTRYPOINT ["java", "-cp", "tracker.jar", "ru.job4j.tracker.StartUI"]