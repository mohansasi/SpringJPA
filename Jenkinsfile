pipeline {
    agent any
    
    stages {
       
        stage('Example') {
			steps{
			  script {
				if (env.BRANCH_NAME == 'master') {
					echo 'I only execute on the master branch'
				} else {
					echo 'I execute elsewhere'
				}
				
				for (int i=0; i < 5 ; i++) {
						echo 'for '+ i
				}
			  }
			}
		}
    }
}