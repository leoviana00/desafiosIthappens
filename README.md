# desafiosIthappens
Desafios do curso de DevOPs da It Happens

1. Criar um Hello Word em Spring Framework e criar uma classe de teste com Junit para
testar 1 + 1 = 2. Configure também o Jacoco no projeto para se comunicar com o
SonarQube no futuro (Ler esse ​ tutorial​ );

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


