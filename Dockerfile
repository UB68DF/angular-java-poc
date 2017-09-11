
FROM java:8
FROM centos:centos6

MAINTAINER nikhil@sixthblock.com


RUN curl -L https://services.gradle.org/distributions/gradle-4.1-bin.zip -o gradle-4.1-bin.zip
RUN apt-get install -y unzip
RUN unzip gradle-4.1-bin.zip



ENV GRADLE_HOME=/gradle-4.1
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN ["gradle", "build"]

#docker build -t gradle

EXPOSE 8080

#RUN mkdir -p /app/

ADD build/libs/sixth-block-demo.jar /sixth-block-demo.jar

ENTRYPOINT ["java", "-jar", "/sixth-block-demo.jar"]
