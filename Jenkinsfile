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
        
    }
}
