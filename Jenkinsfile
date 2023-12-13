pipeline {
    agent any
    environment {
        JAVA_HOME = '/usr/lib/jvm/jdk-21-oracle-x64'
        registry = "moetezz/medianet"
        registryCredential = 'docker-hub-credentials'
        dockerImage = ''
    }
    tools {
        maven "maven"
    }
    stages {
        stage('Git') {
            steps {
                echo 'Getting Project From Git'
                git branch: 'main',
                url: 'https://Mojitoooo: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@github.com/Mojitoooo/AssuranceCI-CD.git'
            }
        }
            stage('Building our image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
                        }
                                    }
        stage('Deploy our image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
                     }
                 }
             }
        }   
stage('Cleaning up') {
steps{
sh "docker rmi $registry:$BUILD_NUMBER"
}
}
        stage('MVN CLEAN') {
            steps {
                script {
                    echo "test"; 
                    if (isUnix()) {
                        sh '/opt/apache-maven-3.9.5/bin/mvn --batch-mode clean'
                    } else {
                        bat '/opt/apache-maven-3.9.5/bin/mvn --batch-mode clean'
                    }
                }
            }
        }
        stage('MVN COMPILE') {
            steps {
                script {
                    echo "JAVA_HOME: ${env.JAVA_HOME}";
                    if (isUnix()) {
                        sh '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile' ;
                    } else {
                        bat '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile' ;
                    }
                }
            }
        }
        stage('MVN SONARQUBE'){
            steps{
                echo 'Sonar static test ...';
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=media';
            }
        }
        stage('Run JMeter'){
            steps{
            build job: 'Metrics'
            }
        }
    }
}
