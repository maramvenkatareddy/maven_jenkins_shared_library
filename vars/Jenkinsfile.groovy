def call ( ) {


pipeline {
    agent { label 'terraform' }
    triggers { pollSCM('* * * * *') }
    
    stages {
        stage ('sourcecode') {
            steps {
                git url: "https://github.com/maramvenkatareddy/maven_jenkins_shared_library.git"
                    branch: 'main'
            }
        }
        /*stage ('build the code') {
            steps {
                sh 'mvn package'
            }
        }*/
    }
}

}