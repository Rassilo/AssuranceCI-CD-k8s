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
        
        stage('MVN COMPILE') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn --batch-mode compile'
                    } else {
                        bat 'mvn --batch-mode compile'
                    }
                }
            }
        }
        /*
        stage('Test') {
            steps {
                script {
                    // Set up the environment
                    def mvnHome = tool 'Maven'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"
                    
                    // Run the unit tests
                    sh "mvn clean test"
                }
            }
        }
*/
        /*stage('Test Reporting') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }*/
        
        /* Uncomment and modify other stages as needed */
        
        /*
       /* stage('Test Email Configuration') {
            steps {
                script {
                    def response = httpRequest(
                        url: 'http://192.168.1.152:8080/manage/descriptorByName/hudson.tasks.Mailer/sendTestMail',
                        method: 'POST',
                        headers: [
                            'Jenkins-Crumb': "${env.JENKINS_CRUMB}"
                        ]
                    )
                    
                    println response.content
                }
            }
        }*/
        
        stage('MVN SONARQUBE') {
            steps {
                echo 'Sonar static test ...'
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=media'
            }
        }
        */
    }
}
