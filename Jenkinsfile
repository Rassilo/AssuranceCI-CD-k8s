pipeline {
    agent any
     environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-11.0.17.0.8-2.el7_9.x86_64'
        M2_HOME = '/opt/maven' 
        PATH = "${env.JAVA_HOME}/bin:${env.M2_HOME}/bin:${env.PATH}"
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
                        if (isUnix()) 
                            {
                                sh '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile';
                            }
                        else
                            {
                                bat '/opt/apache-maven-3.9.5/bin/mvn --batch-mode compile';
                            }
                    }
                 }
        }
        
    }
}
