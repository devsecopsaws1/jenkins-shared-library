#!/usr/bin/env groovy

// This is a Jenkins shared library function to build a Docker image using Docker
def call( String imageName) {
    echo "Building Docker image..."
    withCredentials([
        usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
    ]) {
        sh "docker build -t $imageName ."
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
        sh "docker push $imageName "
    }
    // Replace 'my-docker-image' with your desired image name   
}


//builImage 'rameshm1/demo-java-app:1.2.0'

//filenameofgroovy.functioname