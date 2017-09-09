FROM java:8

RUN curl -L https://services.gradle.org/distributions/gradle-4.1-bin.zip -o gradle-4.1-bin.zip
RUN apt-get install -y unzip
RUN unzip gradle-4.1-bin.zip

#RUN echo 'export GRADLE_HOME=/app/gradle-4.1' >> $HOME/.bashrc
#RUN echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> $HOME/.bashrc

ENV GRADLE_HOME=/app/gradle-4.1
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN source ~/.bashrc

RUN gradle clean build

EXPOSE 8080

RUN mkdir -p /app/

ADD build/libs/sixth-block-demo.jar /app/sixth-block-demo.jar

ENTRYPOINT ["java", "-jar", "/app/sixth-block-demo.jar"]
