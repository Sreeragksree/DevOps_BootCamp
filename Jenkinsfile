node {
    def dockerTool = tool name: 'docker', type: 'dockerTool'
    def dockerCmd = "${dockerTool}/bin/docker"
    stage('git') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Sreeragksree/SpringbootApp.git']]])
    }
    stage('build') {
        def mavenhome = tool name:'maven-3',type: 'maven'
        def mavencmd = "${mavenhome}/bin/mvn"
        sh "${mavencmd} clean package spring-boot:repackage"
    }
    
    stage('docker') {
        
        
        sh "${dockerCmd} build -t sreeragksree/cicd:demo ."
        
    }
    stage('dockerpush'){
        withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerpwd')]) {
        sh "${dockerCmd} login -u sreeragksree -p $dockerpwd"
        sh "${dockerCmd} push sreeragksree/cicd:demo"
}
    
}
    stage('pcf'){
        withCredentials([usernamePassword(credentialsId: 'pcf', passwordVariable: 'PCFPASSWORD', usernameVariable: 'PCFUSERNAME')]) {
        sh "cf login -a https://api.run.pivotal.io --skip-ssl-validation -u $PCFUSERNAME -p $PCFPASSWORD -o cicd-demo-org -s development"
        sh "cf push my-test-app --docker-image sreeragksree/cicd:demo --random-route"
        
}
    }
}
