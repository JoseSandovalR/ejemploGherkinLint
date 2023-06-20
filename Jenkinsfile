pipeline {
  agent any

  stages {


    stage('Lint') {
      steps {
        // Ejecutar Gherkin Lint en los archivos de características
    sh 'gherkin-lint -c src/test/.gherkin-lintrc src/test/resources/feature --format html > gherkin-lint-report.html'
      }
    }

    // Agrega más etapas según tus necesidades

    stage('Publish Report') {
      steps {
        // Publicar el archivo de reporte como un artefacto del pipeline utilizando el plugin HTML Publisher
        publishHTML target: [
          allowMissing: false,
          alwaysLinkToLastBuild: false,
          keepAll: true,
          reportDir: '',
          reportFiles: 'gherkin-lint-report.html',
          reportName: 'Gherkin Lint Report'
        ]
      }
    }
  }
}
