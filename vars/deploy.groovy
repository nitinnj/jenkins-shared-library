def call() {

    sh '''
        echo "===== DEPLOYMENT STARTED ====="

        docker compose down || true

        docker compose pull

        docker compose up -d

        docker ps

        echo "===== DEPLOYMENT COMPLETED ====="
    '''
}
