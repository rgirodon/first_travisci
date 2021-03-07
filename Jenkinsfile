pipeline {
    agent {
    	docker {
            image 'maven:3.6-alpine' 
            args '-v $HOME/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage("SonarQube analysis") {
        	steps {
            	withSonarQubeEnv(credentialsId: '3b10c69f40f4b0c81554ef52b2adf5eae02f129a', installationName: 'rgirodon_first_ci_cd') {
                	sh 'mvn sonar:sonar'
              	}
            }
        }
    }
}