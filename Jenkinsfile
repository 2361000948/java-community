pipeline {
    agent any

    environment {
        ARTIFACTORY_URL = 'http://10.155.171.4/artifactory'
        REPO_NAME = 'generic_test'
        GITHUB_REPO = 'https://github.com/2361000948/java-community.git'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: "${GITHUB_REPO}"
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Building the project..."
                    sh 'echo "Hello, Jenkins!" > build_output.txt'
                }
            }
        }

        stage('Upload to Artifactory') {
            steps {
                script {
                    def rtServer = Artifactory.server "my-artifactory"
                    def buildInfo = Artifactory.newBuildInfo()

                    def gradleUpload = """{
                       "files": [
                          {
                             "pattern": "build_output.txt",
                             "target": "generic_test/test-trigger/",
                             "flat": "true"
                          }
                       ]
                    }"""

                    buildInfo.name = "my-build"
                    buildInfo.number = "${env.BUILD_NUMBER}"

                    rtServer.upload(spec: gradleUpload, buildInfo: buildInfo) 
                    rtServer.publishBuildInfo(buildInfo)
                }
            }
        }
    }
}