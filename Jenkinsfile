pipeline{

    agent {
        label 'windows'
    }
        
        environment {

            DOCKER_CREDENTIALS_ID= 'dockerhub'
            DOCKER_IMAGE_NAME= 'samadhangapat/productdetailsms:latest'
            
        }

        stages{


            stage('checkout'){

                steps {

                    git url: 'https://github.com/Samraj10/productdetailsms.git', branch: 'master'

                }

            }


            stage('build'){

                steps {

                    bat 'mvn clean package'
                }
            }
            stage('test'){

                steps {

                    bat 'mvn test'
                }

            }

            stage ('check docker version') {

                steps {

                    script {
                    // Verify Docker is available
                    bat 'docker --version'
                     }
                }

            }

            stage ('build docker image') {

                steps {

                    script {

                        docker.build('samadhangapat/productdetailsms:latest')
                    }
                }
            }
            

             stage('Push Docker Image') {
                steps {
                    script {
                        docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                            docker.image('samadhangapat/productdetailsms:latest').push()
                        }
                    }
                }
            }                  


            stage('SSH into Ansible Server and Run Playbook') {
            steps {
                // Use the SSH Publisher plugin to run commands on the remote ser
                sshPublisher( 
                    publishers: [
                        sshPublisherDesc(
                            configName: 'ansible_server',  // Name of the SSH server configured in Jenkins
                            transfers: [
                                sshTransfer(
                                    sourceFiles: '**/ansible/k8s-ims/*',  // Source files to transfer (optional)
                                     remoteDirectory: '/power-tiller-app/',  // Remote directory (optional) 
                                    execCommand: 'ansible-playbook /home/samra/power-tiller-app/k8s-prdms/sites.yml',  // Command to execute
                                    removePrefix: '',  // Remove prefix from transferred files (optional)
                                    execTimeout: 120000,  // Execution timeout in milliseconds (optional)
                                    usePty: true  // Use Pseudo Terminal (optional)
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false,
                            verbose: true
                        )
                    ]
                )
            }
        }
            
     }   

}