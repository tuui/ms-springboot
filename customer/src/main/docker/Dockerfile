FROM java:8

ADD customer.jar /

VOLUME /logs

EXPOSE 8091

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "customer.jar"]

# Start docker container: docker run -d -p 8091:8091 --name customer --link eureka:eureka --link config:config ms-customer