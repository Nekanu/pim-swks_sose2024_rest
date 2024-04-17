FROM maven:3.8.6-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY . .

RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/rest-springboot/target/rest-springboot*.jar rest-springboot.jar

EXPOSE 8080

CMD ["java", "-jar", "rest-springboot.jar"]
