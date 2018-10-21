pipeline {
  agent any
  stages {
    stage('init') {
      steps {
        sh 'cp -R /var/postgres_data ./postgres_data'
      }
    }
    stage('mvn build') {
      steps {
        script {
            docker.image('postgres:9.6.10').withRun("-e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -v /var/postgres_data:/var/lib/postgresql/data") { c ->
                docker.image('maven:3.5.4-jdk-8-alpine').withRun("-v $HOME/.m2:/var/maven/.m2 --link ${c.id}:db") { c2 ->
                    sh 'mvn -Dmaven.repo.local=/var/maven/.m2 -DDB_ADDR=db clean install'
                }
            }
        }
      }
    }
  }
}