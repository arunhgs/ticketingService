pipeline {
    agent any

    stages {

        stage('Pre Build') {
		steps {
      			echo "Cloning code from git branch ${env.BRANCH_NAME}"
		}

	}

        stage('Build') {
            steps {
                echo 'Building..'
		sh 'mvn clean install'
      		withMaven(maven: 'Maven', jdk: 'java8') { }
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
