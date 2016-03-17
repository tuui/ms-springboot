FROM java:8

ADD order.jar /

VOLUME /logs

EXPOSE 8092

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "order.jar"]

# Start docker container: docker run -d -p 8092:8092 --name order --link eureka:eureka --link config:config --link customer:customer --link product:product --link activemq:activemq ms-order