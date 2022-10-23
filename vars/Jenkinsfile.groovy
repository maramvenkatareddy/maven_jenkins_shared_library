def call (url) {

pipeline {
    agent { label 'terraform' }
    triggers { pollSCM('* * * * *') }
    
    stages {
        stage ('sourcecode') {
            steps {
                git url: "${url}"
                    branch: 'devlop'
            }
        }
        stage ('build the code') {
            steps {
                sh 'mvn package'
            }
        }
    }
}

}