FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DOCKERIZE_VERSION
ARG ARTIFACT_NAME
ARG EXPOSED_PORT
ENV SPRING_PROFILES_ACTIVE docker

# Configuring New Relic API key and endpoints
ARG INSIGHTS_INSERT_KEY
ARG NEW_RELIC_METRIC_URI
ARG NEW_RELIC_TRACE_URI
ENV INSIGHTS_INSERT_KEY=${INSIGHTS_INSERT_KEY}
ENV NEW_RELIC_METRIC_URI=${NEW_RELIC_METRIC_URI}
ENV NEW_RELIC_TRACE_URI=${NEW_RELIC_TRACE_URI}

ADD https://github.com/jwilder/dockerize/releases/download/${DOCKERIZE_VERSION}/dockerize-alpine-linux-amd64-${DOCKERIZE_VERSION}.tar.gz dockerize.tar.gz
RUN tar xzf dockerize.tar.gz
RUN chmod +x dockerize
ADD ${ARTIFACT_NAME}.jar /app.jar
RUN touch /app.jar
EXPOSE ${EXPOSED_PORT}
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
