FROM java:8

ADD config.jar /

VOLUME /logs

EXPOSE 8888

ENTRYPOINT ["java", "-Dspring.profiles.active=native,dev_docker", "-jar", "config.jar"]

# Start docker container: docker run -d -p 8888:8888 --name config --link eureka:eureka ms-config