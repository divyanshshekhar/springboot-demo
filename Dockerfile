FROM maven:3.6.3-openjdk-8-slim AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-slim-buster
COPY --from=build /tmp/target/springboot-demo-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
CMD java -jar /usr/local/lib/app.jar