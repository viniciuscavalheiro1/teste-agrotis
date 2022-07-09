FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/teste-agrotis

COPY /target/teste-agrotis*.jar teste-agrotis.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8880

CMD java ${ADDITIONAL_OPTS} -jar teste-agrotis.jar --spring.profiles.active=${PROFILE}