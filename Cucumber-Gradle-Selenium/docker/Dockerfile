# Tahap 1: Build
FROM gradle:8.2-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build

# Tahap 2: Run
FROM openjdk:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/myapp.jar /target/myapp.jar
ENTRYPOINT ["java", "-jar", "/target/myapp.jar"]

