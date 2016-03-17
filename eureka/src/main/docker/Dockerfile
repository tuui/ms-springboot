FROM java:8

ADD eureka.jar /

VOLUME /logs

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka.jar"]

# Start docker container: docker run -d -p 8761:8761 --name eureka ms-eureka