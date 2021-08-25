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
                sh "java -version"
                echo "Check MZ status ..."
                sh "${env.MZ_HOME}/bin/mzsh status platform"
                sh "${env.MZ_HOME}/bin/mzsh status ec1"
                echo "Stop workflows ..."
                sh "${env.MZ_HOME}/bin/mzsh ${env.MZ_CREDENTIALS} wfstop USAGE.*; echo \$?"
                echo "Importing config ..."
                sh "${env.MZ_HOME}/bin/mzsh ${env.MZ_CREDENTIALS} vcimport -d config"
                echo "Start realtime workflows "                
                sh "${env.MZ_HOME}/bin/mzsh ${env.MZ_CREDENTIALS} wfstart USAGE.*; echo \$?"
            }
        }
        stage('Test') {
            steps {
                dir('test/demo-test') {
                    sh 'mvn clean compile test'

                    junit 'target/surefire-reports/*.xml'
                }
                echo 'Testing completed'
            }
        }
        stage('Teardown') {
            steps {
                echo "Stop workflows ..."
                sh "${env.MZ_HOME}/bin/mzsh ${env.MZ_CREDENTIALS} wfstop USAGE.*; echo \$?"
            }
        }
    }
}