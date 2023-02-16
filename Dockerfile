FROM gradle:7.4-jdk11-alpine AS builder
WORKDIR /build

COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true 

COPY . /build
RUN gradle build -x test --parallel

FROM openjdk:11.0-slim
WORKDIR /app

COPY --from=builder /build/build/libs/flight-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 5501

ENTRYPOINT ["java", "-jar", "app.jar"]