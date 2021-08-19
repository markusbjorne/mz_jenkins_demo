pipeline {
    agent any

    environment {
        MZ_HOME='/Users/markush/mz/mz-main/mediationzone/mzhomes/mz'
        MZ_CREDENTIALS='mzadmin/dr'
        JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home'
    }

    stages {
        stage('Prepare') {
            steps {
                echo "Prepare ..."
                sh "uname -a"
                sh "ls ${env.MZ_HOME}"
                sh "pwd"
                sh "ls"
                sh "ls /"
                sh "which java"
                sh "java -version"
                sh "${env.MZ_HOME}/bin/mzsh status platform"
                sh "${env.MZ_HOME}/bin/mzsh status ec1"
                echo "Importing config ..."
                sh "${env.MZ_HOME}/bin/mzsh ${env.MZ_CREDENTIALS} vcimport -d config"
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