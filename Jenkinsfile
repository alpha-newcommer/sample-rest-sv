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
            docker.image('postgres:9.6.10').withRun("-e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -v /var/postgres_data:/var/lib/postgresql/data --name db --net=ci-handson_cinet") { c ->
                docker.image('maven:3.5.4-jdk-8-alpine').inside("-v /var/maven/.m2:/var/maven/.m2 --name build-ctn --net=ci-handson_cinet") {
                    sh 'mvn -Dmaven.repo.local=/var/maven/.m2 -DDB_ADDR=db clean install sonar:sonar jib:buildTar'
                }
            }
        }
      }
    }
    stage('register image') {
      steps {
        sh 'docker load --input target/jib-image.tar'
        sh 'docker image tag sample-rest-sv  localhost:5000/sample-rest-sv'
        script {
          docker.image('registry:2.6').withRun("-v /var/registry-data:/var/lib/registry") { c ->
            sh 'docker push localhost:5000/sample-rest-sv'
          }
        }
      }
    }
  }
}
