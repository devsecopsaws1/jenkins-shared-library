// def call(){
//     echo "Logging into Docker..."
//     withCredentials([
//         usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
//     ]) {
//         sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
//     }
//     echo "Docker login successful."
// }

//def ramesh()


//dockerLogin.ramesh()

import com.example.Docker

def call(String imageName) {

    return new Docker(this).dockerLogin()

}