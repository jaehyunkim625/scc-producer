# Spring Cloud Contract (Producer Side Sample)

## Spring Cloud Contract를 이용한 Producer side 샘플입니다. (feat. Restdoc을 이용한 API Doc생성 추가)

### Main Library Verion
- Spring boot (v.2.6.4)
- Spring Cloud Contract (v3.1.1)
- Restdocs (v2.0.6)
- Asciidoctor (v3.3.2)
- Wiremock (v2.32.0)
- Gradle (v7.4.1)
- JUNIT 5
- JDK 11

### `./gradlew build` 실행시 Contract테스트가 작성/테스트 되고 API DOC이 문서화되는 흐름은 아래와 같습니다.
> 1) build
> 2) test : Unit테스트 실행
> 3) compileJava
> 4) generateContractTests : 작성한 Contract을 기반으로 자동으로 Contract Test Case 생성 (Controller테스트 with MockMvc)
> 5) contractTest : 자동 생성된 Contract Test 실행 > All Success > TestCase단위 별 API스펙 명세서가 adoc파일(Snippet)로 자동 생성(/build/generated-snipet/테스트명/*.adoc)
> 6) asciidoctor : 생성된 xxx.adoc파일(Snippet)을 API DOC HTML문서형태로 생성 (build/docs/asciidoc/index.html)
> 7) generateClientStubs : Contract를 베이스로 한 Consumer가 사용 할 json stub 파일 생성
> 8) verifierStubsJar : Contract를 베이스로 한 Consumer가 사용 할 jar stub 파일 생성
> 9) copyDocument : API DOC HTML파일을 'src/main/resources/static/docs' 로 copy
>10) bootJar : API DOC HTML파일을 'BOOT-INF/classes/static/docs' 로 copy하여 JAR로 패키징

* /src/docs/asciidoc/*.adoc : Snippet파일 중 필요한 정보만 include 하여 HTML파일(API Doc)를 만들기위한 Template파일

### Contract를 기반으로 생성된 Subbing용 json or jar 파일은 wiremock을 엔진베이스로 
### 로컬 Standalone 혹은 k8s서비스 형태(Helm)로 공개되어 Consumer Side에서 컨트랙트 테스트용으로 사용되는 것을 시나리오로 함

### Reference Documentation

* [Spring Cloud Contract Reference Documentation](https://docs.spring.io/spring-cloud-contract/docs/current/reference/html/)

* [Groovy DSL 작성법](https://cloud.spring.io/spring-cloud-contract/2.0.x/multi/multi__contract_dsl.html)
