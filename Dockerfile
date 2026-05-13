FROM maven:3.9-eclipse-temurin-21 AS build 

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -Dmaven.test.skip=true -Dmaven.wagon.http.retryHandler.count=3

FROM eclipse-temurin:21-jr-alpine 

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=pro

ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]