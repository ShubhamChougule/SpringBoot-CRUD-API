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
					sh 'build here...'
            				sh 'run tests here if you like ...'
			}
		}
		stage('Deploy') {
			steps {
					echo "Deployment to nexus successfully"
			}
		}
	}
}
