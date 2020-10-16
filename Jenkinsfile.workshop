pipeline{
  agent {
     label 'maven'
 }
 stages {
   stage('Build JAR') {
     steps {
         git url: 'https://github.com/vinay-83/k8s-app-pr'
         sh "mvn package"
     }
   }
   stage('Archive JAR') {
     steps {
         sh "mvn deploy -DskipTests"
     }
   }
   stage('Build Image') {
     steps {
       script {
         openshift.withCluster() {
            openshift.withProject() {
              openshift.startBuild("k8s-app-pr",
                                    "--from-file=target/k8s-app-pr.jar",
                                    "--wait")
            }
         }
       }
     }
   }
   stage('Deploy') {
     steps {
        script {
          openshift.withCluster() {
            openshift.withProject() {
              def result, dc = openshift.selector("dc", "k8s-app-pr")
              dc.rollout().latest()
              timeout(){
                   result = dc.rollout().status("-w")
              }
              if (result.status != 0) {
                  error(result.err)
              }
            }
          }
        }
     }
   }
 }
}
