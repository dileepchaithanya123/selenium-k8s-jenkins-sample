pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("selenium-k8s-jenkins-sample:${env.BUILD_NUMBER}");
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                // Assumes kubectl is configured on the Jenkins agent
                sh 'kubectl apply -f k8s/deployment.yaml'
            }
        }
    }
}