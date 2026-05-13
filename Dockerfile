# Etapa 1: Construcción
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B -Dmaven.wagon.http.retryHandler.count=3

COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true -Dmaven.wagon.http.retryHandler.count=3

FROM eclipse-temurin:25-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=pro

ENTRYPOINT ["java", "-jar", "app.jar"]