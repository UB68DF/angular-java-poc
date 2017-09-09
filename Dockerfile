FROM java:8

EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/sixth-block-demo.jar /app/sixth-block-demo.jar
ENTRYPOINT ["java", "-jar", "/app/sixth-block-demo.jar"]
