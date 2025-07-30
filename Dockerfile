FROM amazoncorretto:24-alpine AS build
WORKDIR /app
RUN apk add --no-cache maven
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q clean package -DskipTests

FROM amazoncorretto:24-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "/app/app.jar"]