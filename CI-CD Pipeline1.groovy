pipeline {
    agent { label 'test_node' }

    stages {
        stage('Git cloning') {
            steps {
                git branch: 'main',
                url: 'https://github.com/aggrawalshanky/Devops-Capstone-Project-2.git'
            }
        }

        stage ('Building a dockerimage') {
            steps {
                sh 'docker rm -f $(docker ps -aq)'
                sh 'docker build -t aggrawalshanky/testimage .'
                sh 'docker run -d --name container1 -p 8080:80 aggrawalshanky/testimage'
                sh 'docker push aggrawalshanky/testimage'
            }
        }
    }
}
