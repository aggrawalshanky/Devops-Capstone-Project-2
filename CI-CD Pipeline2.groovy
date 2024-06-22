pipeline {
    agent { label 'prod'}

    stages {
        stage ('cloning Git-repo') {
            steps {
                git branch: 'main', 
                url: ' https://github.com/aggrawalshanky/Devops-Capstone-Project-2.git'
            }
        }
        stage ('production by k8s') {
            steps {
                sh 'kubectl apply -f production.yml'
            }
        }
    }
}
