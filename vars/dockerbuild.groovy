def call(String imageName, String imageVersion) {
    sh "docker build -t ${env.DOCKERHUB_USER}/${imageName}:${imageVersion} ."
}

