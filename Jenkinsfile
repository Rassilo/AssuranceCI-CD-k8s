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
                sh 'mvn -f \Assurance\Assurance-backend\api-gateway\pom.xml clean package'
                sh 'mvn -f \Assurance\Assurance-backend\Authenticator-Service\pom.xml clean package'
                sh 'mvn -f \Assurance\Assurance-backend\Contrat-Service\pom.xml clean package'
                sh 'mvn -f \Assurance\Assurance-backend\eureka-discovery-service\pom.xml clean package'
                sh 'mvn -f \Assurance\Assurance-backend\Souscription-assurance-Service\pom.xml clean package'
                sh 'mvn -f \Assurance\Assurance-backend\TypeAssurance-Service\pom.xml clean package'
            }
        }
        
    }
}
