FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean install

FROM eclipse-temurin:23-jre


COPY --from=build /app/target/marketplace-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java","-jar","app.jar"]