# Wiremock을 이용한 Stubbing용 Contract Server

### References 
* https://wiremock.org/docs/running-standalone/

### 1. Stubbing용 파일 (json/jar) 생성: Contract를 기반한 Subbing용 파일을 작성
* Gradle빌드 실행 > Under 'build/stubs/META-INF/com.example.scc/scc-producer/0.0.1-SNAPSHOT/mappings'

### 2. 생성된 sutb파일 (json or jar)을 contract-mock-server에 copy하여 contract server가 기동시 파일들을 import함
* Copy under 'contract-mock-server/wiremock-docker/wiremock-docker-stub'

### 3. Start contract-mock-server
`
docker-compose -f ./contract-mock-server/wiremock-docker/docker-compose.yaml -p contract-server up -d
`
### 4. Stop contract-mock-server
`
docker-compose -f ./contract-mock-server/wiremock-docker/docker-compose.yaml -p contract-server down
`