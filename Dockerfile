#---------------------------------------------------------------
# Informação
# autor: Leonardo Viana Pereira
# email: leonardo.viana@armateus.com.br
# version: 0.1.0
# Descrição: Dockerizando a aplicação
# Desafio do Curso de DevOps | Ithappens - Referente aos módulos 1 e 2
#---------------------------------------------------------------
#

FROM tomcat:8.5.50-jdk8-openjdk
LABEL maintainer "leonardoviana00@hotmail.com"
RUN apt-get update &&\
    apt-get clean
COPY target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/desafio65.war
RUN sh -c 'touch /usr/local/tomcat/webapps/desafio65.war'
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/desafio65.war"]
