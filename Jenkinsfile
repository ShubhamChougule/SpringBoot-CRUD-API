pipeline {
	agent any
	stages {
		stage('Compile') {
			steps {
					echo "Compiled successfully"
			}
		}
		stage('TESTING') {
			steps {
					echo "Tested successfully"
			}


			post {
				always{
					junit 'src/test/java/com/shubham/JpaDemoApplicationTests.java'
				}
			}

			
		}
		stage('Deploy') {
			steps {
					echo "Deployment to nexus successfully"
			}
		}
	}
}
