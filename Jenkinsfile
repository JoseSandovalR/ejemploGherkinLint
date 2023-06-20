pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // Clonar el repositorio de GitHub
        git credentialsId: 'github-credentials', url: 'https://github.com/JoseSandovalR/ejemploGherkinLint'
      }
    }

    stage('Lint') {
      steps {
        // Ejecutar Gherkin Lint en los archivos de características
        sh 'gherkin-lint -c src/test/.gherkin-lintrc src/test/resources/feature'
      }
    }

    // Agrega más etapas según tus necesidades
  }
}
