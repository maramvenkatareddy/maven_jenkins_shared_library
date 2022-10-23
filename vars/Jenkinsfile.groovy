def call() {


    pipeline {
        agent { label 'terraform' }
        triggers { pollSCM('* * * * *') }

        stages {
            stage ('sourcecode') {
                steps {
                    git url: 'https://github.com/maramvenkatareddy/spring-petclinic-fork.git',
                        branch: 'main'
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
