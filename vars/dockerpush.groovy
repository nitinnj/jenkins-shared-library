def call(String imageName, String imageVersion, String dockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCreds',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push ${dockerHubUser}/${imageName}:${imageVersion}
        """
    }
}
