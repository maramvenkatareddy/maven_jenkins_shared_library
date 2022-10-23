def call(String url = 'https://github.com/maramvenkatareddy/spring-petclinic-fork.git') {


    pipeline {
        agent { label 'terraform' }
        triggers { pollSCM('* * * * *') }

        stages {
            stage ('sourcecode') {
                steps {
                    git url: "${url}",
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
