# Tarefas do desafio referente aos módulos 1 e 2 do curso de DevOps da It Happens

### Desafios do curso de DevOPs da It Happens

1. Criar um Hello Word em Spring Framework e criar uma classe de teste com Junit para
testar 1 + 1 = 2. Configure também o Jacoco no projeto para se comunicar com o
SonarQube no futuro;

2. Instalar o Jenkins utilizando Docker com volume, para garantir persistência (Monte um
Dockerfile com uma instalação de Jenkins que contemple o Docker e Maven);

3. Instalar o SonarQube com Docker com volume, para garantir persistência;

4. Instalar o Gitlab com Docker com volume, para garantir persistência

5. Integrar o Jenkins, Gitlab e SonarQube;

6. Construir o pipeline no modelo Groovy file no Jenkins com as etapas:

 - Pull do Git (do repositório do gitlab que você colocou o código fonte da parte 1 dessa
tarefa);

 - Build com Maven;
 
 - Teste (rode os testes com o maven);
 
 - SonarQube;
 
 - Dockerização (ver como dockerização aplicação Spring em ​ link​ );
 
 - Salvar release em Registry (salve no DockerHub);
 
 - Deploy (Faça o deploy usando Ansible e módulo docker para a sua máquina pessoal
mesmo);

Restrições:
Porta: 8080;
Limite de memória: 1GB;
Limite de CPU: 1 Core.

# Desafio 02

- Dockerfile (Jenkins, Maven e Docker)
- plugins.sh (Plugins para instalação de forma automatizada)
- Criação de volumes para persistência dos dados

docker volume create jenkins_home
  
- Criação de containers

docker run -d --name jenkins-desafio --restart always --hostname jenkins.desafio.com  -p 8282:8080 -p 50000:50000 \
-v /var/run/docker.sock:/var/run/docker.sock \
-v jenkins_home:/var/jenkins_home \
leoviana00/desafio02:0.4.0

# Desafio 03 - SONARQUBE

- Criação de volume

docker volume create sonar_data
docker volume create sonar_conf
docker volume create sonar_logs
docker volume create sonar_extensions

- Criar container

docker run -d \
--name sonar-desafio \
--hostname sonar.desafio.com \
--restart always \
--link jenkins-desafio \
-p 9000:9000 \
-v sonar_data:/opt/sonarqube/data \
-v sonar_conf:/opt/sonarqube/conf \
-v sonar_logs:/opt/sonarqube/logs \
-v sonar_extensions:/opt/sonarqube/extensions \
sonarqube:latest

OBS: Instalar no Jenkins Plugin: SonarQube Scanner for Jenkins para integração

# Desafio 04 - GITLAB

- Criação de volumes

docker volume create gitlab_config
docker volume create gitlab_logs
docker volume create gitlab_data

- Criar container

docker run -d \
 -p 443:443 -p 80:80 -p 2022:22 --hostname gitlab.desafio.com --link jenkins.desafio.com --name gitlab-desafio --restart always \
 -v gitlab_config:/etc/gitlab \
 -v gitlab_logs:/var/log/gitlab \
 -v gitlab_data:/var/opt/gitlab \
 gitlab/gitlab-ce:latest

# Desafio 05 - Integrar Jenkins - Gitlab - Sonar

# Desafio 06 - Construção Pipeline

1. Realizar o pull do projeto

  sh 'git clone git@172.17.0.3:leoviana00/desafio-6.1.git'

2. Realizar Build com o Maven

  sh 'mvn clean package' 

3. Realizar os testes com o Maven

  sh 'mvn teste'

4. Análise com o SonarQube

5. Quality Gate

6. Docker Build

  sh 'docker rmi -f leoviana00/desafio_prod'
  sh 'docker build -t leoviana00/desafio_prod .'

7. Docker Push

  sh 'docker image tag leoviana00/desafio_prod localhost:5000/desafio_prod'
  sh 'docker push leoviana00/desafio_prod'

8. Deploy em ambiente de Homologação

  sh 'docker-compose up -d'

9. Deploy em ambiente de produção com Ansible

  sh 'ansible-playbook -i hosts playbook.yml'

10. Publicação dos testes unitários

# Ansible

1. hosts
2. playbook.yml
3. roles
3.1. docker
3.1.1. tasks    - main.yml
3.1.2. vars     - main.yml 
3.1.3. handlers - main.yml


# TASKS

- INSTALAÇÃO DAS DEPENDÊNCIAS DO DOCKER E PIP
- ADICIONANDO CHAVE PÚBLICA GPG DO DOCKER AO CHAVEIRO APT
- ADICIONANDO REPOSITÓRIO DOCKER
- CONFIGURAÇÃO DO REPOSITÓRIO
- INSTALAÇÃO DO DOCKER
- INSTALAÇÃO PACOTES PYTHON
- CRIAÇÃO DOS CONTAINERS

