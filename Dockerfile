# FROM eclipse-temurin:21
# RUN mkdir /opt/app
# COPY japp.jar /opt/app
# CMD ["java", "-jar", "/opt/app/japp.jar"]



# Build stage
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package

# Run stage
FROM eclipse-temurin:21-jre
RUN mkdir -p /opt/app
COPY --from=builder /app/target/japp.jar /opt/app/japp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/japp.jar"]

# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# COPY build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 3000
# ENTRYPOINT exec java $JAVA_OPTS -jar demo.jar
# # For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# #ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar demo.jar
