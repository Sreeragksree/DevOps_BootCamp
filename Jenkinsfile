node {
    def dockerTool = tool name: 'docker', type: 'dockerTool'
    withEnv(["DOCKER=${dockerTool}/bin"]) {
    stage('git') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Sreeragksree/SpringbootApp.git']]])
    }
    stage('buidl') {
        def mavenhome = tool name:'maven-3',type: 'maven'
        def mavencmd = "${mavenhome}/bin/mvn"
        sh "${mavencmd} clean package spring-boot:repackage"
    }
    
    stage('docker') {
        
        
        dockerCmd "build -t sreeragksree/cicd:demo ."
    }
    stage('dockerpush'){
        withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerpwd')]) {
        sh "docker login -u sreeragksree -p $dockerpwd"
        sh "docker push sreeragksree/cicd:demo"
}
    }
    

}
}
def dockerCmd(args) {
            sh "sudo ${DOCKER}/docker ${args}"
        }
