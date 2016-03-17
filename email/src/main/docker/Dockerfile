FROM java:8

ADD email.jar /

VOLUME /logs

EXPOSE 8094

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "email.jar"]

# Start docker container: docker run -d -p 8094:8094 --name email --link eureka:eureka --link config:config --link activemq:activemq ms-email