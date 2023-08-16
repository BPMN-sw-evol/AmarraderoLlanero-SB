FROM openjdk:17-jdk-slim-buster
VOLUME /tmp
ADD target/amarraderollanero-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]