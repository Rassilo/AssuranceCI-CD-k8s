pipeline {
    agent any
    
    stages {
        stage('Git') {
            steps {
                echo 'Getting Project From Git'
                git branch: 'main',
                url: 'https://Mojitoooo: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@github.com/Mojitoooo/AssuranceCI-CD.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the project'
                sh 'mvn -f Authenticator-Service/pom.xml clean package'
                sh 'mvn -f Contrat-Service/pom.xml clean package'
                sh 'mvn -f eureka-discovery-service/pom.xml clean package'
                sh 'mvn -f Souscription-assurance-Service/pom.xml clean package'
                sh 'mvn -f TypeAssurance-Service/pom.xml clean package'
                
            }
        }
        
    }
}
