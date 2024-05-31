pipeline{

    agent {
        label 'windows'
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


                
             
        }   

}