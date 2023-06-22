pipeline {
  agent any

  stages {
    stage('Lint') {
      steps {
        // Ejecutar Gherkin Lint en los archivos de características
        sh 'gplint -c src/test/.gherkin-lintrc src/test/resources/feature'
      }
    }

    // Agrega más etapas según tus necesidades
  }
}
