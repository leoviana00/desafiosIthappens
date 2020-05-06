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

 6.1 Pull do Git (do repositório do gitlab que você colocou o código fonte da parte 1 dessa
tarefa);

 6.2 Build com Maven;
 
 6.3 Teste (rode os testes com o maven);
 
 6.4 SonarQube;
 
 6.5 Dockerização (ver como dockerização aplicação Spring em ​ link​ );
 
 6.6 Salvar release em Registry (salve no DockerHub);
 
 6.7 Deploy (Faça o deploy usando Ansible e módulo dócker para a sua máquina pessoal
mesmo);

Restrições:
Porta: 8080;
Limite de memória: 1GB;
Limite de CPU: 1 Core.
