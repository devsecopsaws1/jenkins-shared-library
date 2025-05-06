def call(){
    echo "Logging into Docker..."
    withCredentials([
        usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
    ]) {
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
    }
    echo "Docker login successful."
}