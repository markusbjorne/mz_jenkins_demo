pipeline {
    agent any

    environment {
        MZ_HOME='/Users/markush/mz/mz-main/mediationzone/mzhomes/mz'
        JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home'
    }

    stages {
        stage('Build') {
            steps {
                sh "echo setup..."
                sh "uname -a"
                sh "ls /Users/markush/mz/mz-main/mediationzone/"
                sh "pwd"
                sh "ls"
                sh "ls /"
                sh "which java"
                sh "java -version"
                sh "/Users/markush/mz/mz-main/mediationzone/mzhomes/mz/bin/mzsh status platform"
                sh "/Users/markush/mz/mz-main/mediationzone/mzhomes/mz/bin/mzsh status ec1"
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