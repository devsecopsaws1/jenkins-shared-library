#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def dockerLogin() {
        script.echo "Logging into Docker..."
        script.withCredentials([
            script.usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
        ]) {
            script.sh "echo $script.DOCKER_PASSWORD | docker login -u $script.DOCKER_USERNAME --password-stdin"
        }
        script.echo "Docker login successful."
    }

    def buildImage(String imageName) {
        script.echo "Building Docker image..."
        script.withCredentials([
            script.usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
        ]) {
            script.sh "docker build -t $imageName ."
            //script.sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
            //script.sh "docker push $imageName "
        }
    }

    def pushImage(String imageName) {
        script.echo "Pushing Docker image..."
        script.sh "docker push $imageName"
    }
    
}

/*
class MyClass:
   def _init_(self,a,b)
      self.a=a
       self.b=b
   def method(self):
     print(self.a,self.b)
*/

// fkldjfsdlj

