pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // Clonar el repositorio de GitHub
        git 'https://github.com/tu-usuario/tu-repositorio.git'
      }
    }

    stage('Lint') {
      steps {
        // Ejecutar Gherkin Lint en los archivos de características
        bat 'gherkin-lint -c src/test/.gherkin-lintrc src/test/resources/feature'
      }
    }

    // Agrega más etapas según tus necesidades
  }
}
