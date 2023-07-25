pipeline {
  agent any

  stages {
    stage('Lint') {
      steps {
        script {
          // Capturar la salida de gplint en una variable de entorno
          env.LINT_OUTPUT = sh(returnStdout: true, script: 'gplint -c .gplintrc src/test/resources/feature || true').trim()
        }
      }
    }


    stage('Generate XML report') {
      steps {
        // Clonar el repositorio que contiene el script de Python
        git branch: 'main', url: 'https://github.com/JoseSandovalR/gplintToXmlPython.git'

        // Asegurarse de que Python esté instalado y luego ejecutar el script de Python
        sh '''
        python3 --version
        echo "${LINT_OUTPUT}" > lint_output.txt
        python3 gpLintReportToXml.py lint_output.txt
        '''
      }

      post {
            always {
                recordIssues enabledForFailure: true, aggregatingResults: true, tool: checkStyle(pattern: 'report.xml')
            }
        }
    }

    // Agrega más etapas según tus necesidades
  }
}
