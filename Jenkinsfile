pipeline {
  agent any

  stages {
    stage('Lint') {
      steps {
<<<<<<< HEAD
        script {
          // Capturar la salida de gplint en una variable de entorno
          env.LINT_OUTPUT = sh(returnStdout: true, script: 'gplint -c .gherkin-lintrc src/test/resources/feature || true').trim()
        }
=======
        // Ejecutar Gherkin Lint en los archivos de características
        script {
          // Capturar la salida de gplint en una variable de entorno
          env.LINT_OUTPUT = sh(returnStdout: true, script: 'gplint -c src/test/.gherkin-lintrc src/test/resources/feature').trim()
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
        python3 process_output.py lint_output.txt
        '''
>>>>>>> aaedc55e8af0ee9be7d1bd1348988608b44ed59f
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