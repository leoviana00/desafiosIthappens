pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage ('Pull Git') {
            steps {
                checkout scm
            }
        }
        stage ('Build com Maven'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage ('Testes com o Maven'){
            steps{
                sh 'mvn test'
            }
        }

        stage ('Análise com sonar'){
            environment{
                scannerHome = tool'Scanner 4.3'
            }
            steps{
                withSonarQubeEnv('Sonar'){
                sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=Pipeline-Desafio6 -Dsonar.host.url=http://172.17.0.4:9000 -Dsonar.login=3288c8fd1c7084fd791fd53f8a94c992e7aea119 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/controller/**,**Application.java "
                }
            }
        }

        stage ('Quality Gate'){
            steps{
                sleep(10)
                timeout(time: 1, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }
            }
        }

         stage ('Docker Build'){
            steps{

                sh 'docker rmi -f desafio_prod'
                sh 'docker build -t desafio_prod .'
                
            }
        }

        stage ('Docker Push'){
            steps{
                sh 'docker rmi -f 172.17.0.5:5000/desafio_prod'
                sh 'docker image tag desafio_prod 172.17.0.5:5000/desafio_prod'
                sh 'docker push 172.17.0.5:5000/desafio_prod'
            }
        }

         stage ('Deploy Homologação'){
            steps{
                
                sh 'docker-compose up -d'
            }
        }

        stage ('Deploy com Ansible'){
            steps{
                sh 'ansible-playbook -i hosts playbook.yml'
            }
        }


        stage ('Results'){
            steps{
                
                sh 'echo Fim do pipeline ... Implantando um ambiente seguindo o cronograma dos modúlos 1 e 2 do curso de DevOps It Happens, referente à sua lista de tarefas'
            
            }
        }
        
     }
  
    post{
        always{
            
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'  
        }
    }
   
 }
