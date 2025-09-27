# ====== Build ======
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /opt/app
# Copiamos pom.xml antes para aproveitar cache de dependências
COPY pom.xml .
RUN mvn -B -ntp -q -DskipTests dependency:go-offline
# Agora o código-fonte
COPY src ./src
RUN mvn -B -ntp -DskipTests clean package

# ====== Runtime ======
FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/app

# Copia o artefato construído
COPY --from=build /opt/app/target/*.jar /opt/app/app.jar

# App Java padrão Spring Boot escuta em 8080
EXPOSE 8080

# Healthcheck simples no /ping (ajuste se quiser outro endpoint)
HEALTHCHECK --interval=30s --timeout=5s --retries=3 CMD wget -qO- http://localhost:8080/ping || exit 1

ENTRYPOINT ["java","-jar","/opt/app/app.jar"]