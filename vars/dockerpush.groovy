def call(String credsId, String imageName, String tag) {

    withCredentials([
        usernamePassword(
            credentialsId: dockerHubCreds,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
            echo "Logging in to Docker Hub..."
            docker login -u $DOCKER_USER -p $DOCKER_PASS

            echo "Pushing image..."
            docker tag ${imageName}:${tag} $DOCKER_USER/${imageName}:${tag}
            docker push $DOCKER_USER/${imageName}:${tag}

            echo "Docker push completed"
        """
    }
}
