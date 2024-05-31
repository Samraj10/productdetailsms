pipeline{

    agent {
        label 'ubuntu'
    }

   
        stages{
            stage('checkout'){

                steps {

                    git url: 'https://github.com/Samraj10/mf_second.git', branch: 'master'

                }

            }
            stage('build'){

                steps {

                    sh 'mvn clean package'
                }
            }
            stage('test'){

                steps {

                    sh 'mvn test'
                }

            }

            stage('deploy to ansible server'){

                steps{
                    script{

                        def warFile='target/mf-second.war'
                        def remoteUser='samra'
                        def remoteHost='192.168.59.111'
                        def remotePath='/home/samra/work'
                        def privateKey='/home/samra/.ssh/samra'

                        bat """

                            scp -i ${privateKey} ${warFile} ${remoteUser}@${remoteHost}:${remotePath}
                        """
                        bat """

                            ssh -i ${privateKey} ${remoteUser}@${remoteHost}
                        """

                    }

                }
            } 
        }   

}