FROM java:8

ADD product.jar /

VOLUME /logs

EXPOSE 8093

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "product.jar"]

# Start docker container: docker run -d -p 8093:8093 --name product --link eureka:eureka --link config:config ms-product