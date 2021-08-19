pipeline {
    agent any

    environment {
        MZ_HOME='/Users/markush/mz/mz-main/mediationzone/mzhomes/mz'
        JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home'
    }

    stages {
        stage('Prepare') {
            steps {
                sh "echo setup..."
                sh "uname -a"
                sh "ls ${env.MZ_HOME}"
                sh "pwd"
                sh "ls"
                sh "ls /"
                sh "which java"
                sh "java -version"
                sh "${env.MZ_HOME}/bin/mzsh status platform"
                sh "${env.MZ_HOME}/bin/mzsh status ec1"
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
            }
        }
    }
}