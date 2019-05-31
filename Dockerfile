FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /target/moch-0.0.1-SNAPSHOT.jar moch.jar
RUN sh -c 'touch /moch.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/moch.jar"]