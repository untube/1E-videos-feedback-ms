FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 3004

ADD target/1E-videos-feedback-ms-0.0.1-SNAPSHOT.jar feedback.jar
RUN bash -c 'touch /feedback.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /feedback.jar"]
 
