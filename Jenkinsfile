pipeline {
    agent any

    stages {

        stage('Pre Build') {
    try {
      checkout scm
      echo "Cloning code from git branch ${env.BRANCH_NAME}"
    } catch (exc) {
      echo "unable to pull code from branch ${env.BRANCH_NAME}"
      throw exc
    }

}
        stage('Build') {
            steps {
                echo 'Building..'
		sh 'mvn clean install'
		try {
      withMaven(maven: 'Maven', jdk: 'java8') {
      
      }
    } catch (exc) {
      echo "Build failed"
      throw exc
    }
		
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh 'java -jar ticketSystem.jar'
            }
        }
    }
}
