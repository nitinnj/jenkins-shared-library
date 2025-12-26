def call(String imageName, String imageVersion, String dockerHubUser) {
    sh "docker build -t ${dockerHubUser}/${imageName}:${imageVersion} ."
}

