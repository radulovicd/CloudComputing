FROM maven AS builder
 
WORKDIR /app
 
COPY demo .

RUN mvn clean install -DskipTests


FROM openjdk:11.0.9
 
WORKDIR /app/target

COPY --from=builder /app/target .

ENV POSTGRES_DOMAIN demo-db

EXPOSE 8080
 
CMD java -jar demo-0.0.1-SNAPSHOT.jar
