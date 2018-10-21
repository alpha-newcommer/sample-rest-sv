pipeline {
  agent any
  stages {
    stage('init') {
      steps {
        sh 'cp -R /var/postgres_data ./postgres_data'
      }
    }
    stage('mvn build') {
        agent {
            docker {
                image 'maven:3.5.4-jdk-8-alpine'
                args '-v $HOME/.m2:/var/maven/.m2'
            }
        }
      steps {
        script {
            docker.image('postgres:9.6.10').withRun("-e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -v ./postgres_data:/var/lib/postgresql/data") { c ->
                sh 'mvn -Dmaven.repo.local=/var/maven/.m2 -DDB_ADDR=localhost clean install'
            }
        }
      }
    }
  }
}