FROM openjdk:17-alpine
ARG JAR_FILE=target/amarraderollanero-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]