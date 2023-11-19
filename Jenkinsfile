pipeline {
    agent any
    environment {
                JAVA_HOME = '/usr/lib/jvm/jdk-21-oracle-x64'
                
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
       
        stage('MVN COMPILE'){
            steps{
                script
                    {
                        echo "JAVA_HOME: ${env.JAVA_HOME}";
                        if (isUnix()) 
                            {
                                sh '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile' ;
                            }
                        else
                            {
                                bat '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile' ;
                            }
                    }
                 }
        }
//        stage('MVN SONARQUBE'){
//           steps{
//                echo "JAVA_HOME: ${env.JAVA_HOME}";
//                echo 'Sonar static test ...';
//                withEnv(["PATH+MAVEN=${tool 'maven'}/bin"]) {
//                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=media'
//                }
//            }
//        }

        stage('NEXUS DEPLOY'){
            steps{
                script
                {
                    if (isUnix()) 
                            {
                                sh """mvn deploy -f pom.xml""" ;
                            }
                        else
                            {
                                bat """mvn deploy -f pom.xml""" ;
                            }
                    }
                }
            }
        }
    }

