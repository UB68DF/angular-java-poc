FROM docker.sixthblock.com/java:1.8.0
EXPOSE 8080 8888

CMD["java", "-jar", "sixth-block-demo.jar"]