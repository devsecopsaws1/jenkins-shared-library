#!/usr/bin/env groovy
// This is a Jenkins shared library function to build a JAR file using Maven
def myjar() {
    echo "Building JAR file..."
    sh 'mvn package'
}
