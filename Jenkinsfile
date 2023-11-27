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
        stage('Deploy to Docker Hub') {
            steps {
                script {
                    // Use step function to read Maven POM
                    def mavenInfo = step([$class: 'ReadMavenPom'])
                    
                    // Extract groupId and artifactId from the Maven POM
                    def groupId = mavenInfo.getGroupId()
                    def artifactId = mavenInfo.getArtifactId()

                    // Construct the Docker image name
                    def dockerImageName = "${groupId}/${artifactId}"

                    // Build and deploy the Docker image
                    sh """
                        cd /var/lib/jenkins/workspace/PFE
                        docker build -t ${dockerImageName}:latest .
                        docker push ${dockerImageName}:latest
                    """
                }
            }
        }
    }
}
