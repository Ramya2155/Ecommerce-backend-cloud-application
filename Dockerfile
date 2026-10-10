FROM eclipse-temurin:22-jdk as builder
WORKDIR /build
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests
FROM eclipse-temurin:22-jre
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
COPY ./src/main/resources/application-prod.properties /app/config/application-prod.properties
COPY ./.env /app
ENV SPRING_CONFIG_LOCATION=/app/config/application-prod.properties
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "app.jar"]