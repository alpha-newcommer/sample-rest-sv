pipeline {
  agent any
  stages {
    stage('init') {
      steps {
        sh 'cp -R /var/postgres_data/org_data /var/postgres_data/data'
      }
    }
    stage('mvn build') {
      steps {
        script {
            docker.image('postgres:9.6.10').withRun("-e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -v /var/postgres_data/data:/var/lib/postgresql/data --name db --net=ci-handson_cinet") { c ->
                docker.image('maven:3.5.4-jdk-8-alpine').inside("-v /var/maven/.m2:/var/maven/.m2 --name build-ctn --net=ci-handson_cinet") {
                    sh 'mvn -Dmaven.repo.local=/var/maven/.m2 -DDB_ADDR=db clean install sonar:sonar jib:build'
                }
            }
        }
      }
    }
  }
}
