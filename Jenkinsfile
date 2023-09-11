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
        stage('MVN CLEAN') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn --batch-mode clean'
                    } else {
                        bat 'mvn --batch-mode clean'
                    }
                }
            }
        }
        
    }
}
