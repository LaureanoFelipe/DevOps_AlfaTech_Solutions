FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /opt/app

COPY pom.xml .
RUN mvn -B -ntp -q -DskipTests dependency:go-offline

COPY src ./src
# Gera o jar executável
RUN mvn -B -ntp -DskipTests clean package spring-boot:repackage

FROM eclipse-temurin:21-alpine
WORKDIR /opt/app
COPY --from=build /opt/app/target/*.jar /opt/app/app.jar
EXPOSE 8080
CMD ["java","-jar","/opt/app/app.jar"]