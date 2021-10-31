pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building'
        git(url: 'https://github.com/nicorickert/ids-fund-del-swebok-tp-scm', branch: 'master')
        withGradle() {
          sh './gradlew build'
          sh './gradlew bootRun'
        }

      }
    }

    stage('Test') {
      steps {
        echo 'Testing'
        withGradle() {
          sh './gradlew test'
        }

      }
    }

    stage('Validate') {
      steps {
        echo 'Validating'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying'
      }
    }

  }
}