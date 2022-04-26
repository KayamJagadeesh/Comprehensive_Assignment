pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "rmdir  /s /q Comprehensive_Assignment"  
                bat "git clone https://github.com/KayamJagadeesh/Comprehensive_Assignment.git"
                bat "mvn clean -f  Comprehensive_Assignment"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f Comprehensive_Assignment"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f Comprehensive_Assignment"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f Comprehensive_Assignment"
            }
        }
        
    }
}
