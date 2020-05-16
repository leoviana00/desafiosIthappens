FROM tomcat:8.5.50-jdk8-openjdk
LABEL maintainer "leonardoviana00@hotmail.com"
RUN apt-get update &&\
    apt-get clean
COPY demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/desafio65.war
EXPOSE 8080
RUN sh -c 'touch /usr/local/tomcat/webapps/desafio65.war'
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/desafio65.war"]
