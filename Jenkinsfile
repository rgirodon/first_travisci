pipeline {
    agent {
    	docker {
            image 'maven:3.6.3-jdk-11' 
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
            	withSonarQubeEnv('SonarCloud') {
                	sh 'mvn sonar:sonar'
              	}
            }
        }
    }
}