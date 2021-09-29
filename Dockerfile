FROM openjdk:11-jre-slim
COPY ./target/demo-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "./app.jar"]