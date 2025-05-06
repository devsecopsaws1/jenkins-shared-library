def call(String imageName) {
    echo "Push into Dockerhub..."
    sh "docker push $imageName"
}