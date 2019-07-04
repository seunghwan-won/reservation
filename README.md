# reservation
~~1. maven 프로젝트를 생성합니다.
groupId 와 artifactId 는 임의로 지정합니다.~~

 
~~2. MySQL 에서 프로젝트에 사용할 database 와 사용자 계정을 생성합니다.
생성한 데이터베이스와 계정정보는 src/main/resources/application.properties 파일에 다음과 같이 설정합니다.
spring.datasource.driver-class-name=com.mysql.jdbc.Driver 
spring.datasource.url=jdbc:mysql://domain:port/dbName?useUnicode=true&characterEncoding=utf8 
spring.datasource.username=dbUserName
spring.datasource.password=dbPasswd~~
 

~~3. 프로젝트 루트 폴더에 .gitignore파일을 생성합니다. (gitignore 참고자료)
해당 파일에는 다음의 내용을 입력합니다.
/src/main/resources/application.properties
target
.classpath
.project
.settings~~
 

~~4. 생성한 데이터베이스에 접속하여 주어진 sql을 실행합니다.
먼저 ddl.sql의 내용을 실행하여 테이블을 생성하고, dml.sql의 내용을 실행하여 샘플 데이터를 추가합니다. 코드 바로가기~~

~~5. sample이미지가 있는 압축파일인 img.zip을 webapp 폴더에 압축 해제합니다.
webapp폴더에 img와 img_map 폴더 아래에 샘플 이미지가 위치합니다.~~

 

6. Spring MVC, Spring JDBC를 사용하기 위한 Spring설정 파일들을 작성합니다.

7. 샘플 데이터를 읽어 들여 메인화면을 출력하기 위한 DTO, Controller, Service, Repository를 알맞게 작성합니다.


8. web API 스펙은 아래와 같습니다.

카테고리 목록 구하기 API 스펙 & test

GET (카테고리 목록 구하기): /api/categories
상품 목록 구하기 API 스펙 & test

GET (상품 목록 구하기): /api/products
프로모션 정보 구하기 API 스펙 & test

GET (프로모션 목록 구하기): /api/promotions
 

 

9. image type 설명

th: thumbnail (썸네일 사진 - 상품리스트 혹은 프로모션 정보에서 보여주는 이미지)
ma: main (메인 사진 - 상품 상세정보에서 보여주는 이미지)
et: etc (기타 사진 - 상품 상세정보에서 추가적으로 보여주는 기타 이미지)
