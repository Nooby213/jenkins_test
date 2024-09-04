# 베이스 이미지로 OpenJDK 17 사용
FROM openjdk:17-jdk-slim AS build

# 작업 디렉토리 설정
WORKDIR /app

# Gradle Wrapper와 관련 파일만 먼저 복사
COPY gradlew gradlew
COPY gradle gradle

# gradlew 실행 권한 부여
RUN chmod +x gradlew

# 의존성 설치 (변경 빈도가 적은 의존성만 설치해서 캐싱 효율을 높임)
COPY build.gradle settings.gradle ./
RUN ./gradlew dependencies --no-daemon

# 나머지 소스 코드 복사
COPY . .

# 빌드
RUN ./gradlew build --no-daemon

# 빌드 결과물을 실행할 이미지
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 결과물 복사
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

# 환경 변수 설정 (주석 처리된 부분은 Jenkins에서 설정할 수 있음)
# ENV JASYPT_ENCRYPTOR_PASSWORD=jenkins_will_set_this

# 8000번 포트 노출
EXPOSE 8000

# 실행
CMD ["java", "-jar", "app.jar"]
