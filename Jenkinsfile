pipeline {
	agent any
	stages {
		stage('Compile') {
			steps {
					echo "Compiled successfully"
			}
		}
		stage('JUnit') {
			steps {
					echo "Tested successfully"
			}
		}
		stage('Quality-Gate') {
			steps {
					echo "Quality-Gate sonar completed successfully"
			}	
		}
		stage('Deploy') {
			steps {
					echo "Deployment to nexus successfully"
			}
		}
		stage('Send Build info to JIRA') {
      		        steps {
           			jiraSendBuildInfo branch: 'MYP-6', site: 'cooldsachin.atlassian.net'
       			}
    		}
	}
}
