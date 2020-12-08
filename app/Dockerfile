FROM maven AS builder
 
WORKDIR /app
 
COPY demo .

RUN mvn clean install -DskipTests


FROM openjdk:11.0.9
 
WORKDIR /app/target

COPY --from=builder /app/target .

EXPOSE 8080
 
CMD java -jar demo-0.0.1-SNAPSHOT.jar
