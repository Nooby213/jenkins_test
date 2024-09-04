# 빌드 이미지로 최신 Node.js 버전 지정 (LTS 버전)
FROM node:lts AS build

WORKDIR /app

# 라이브러리 설치에 필요한 파일만 복사
COPY package.json .
COPY package-lock.json .

# 라이브러리 설치
RUN npm ci

# 소스코드 복사
COPY . /app

# 소스코드 빌드
RUN npm run build

# 프로덕션 스테이지 - 최신 Nginx 사용 (alpine 기반)
FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf.template
ENV BACKEND_HOST localhost
ENV BACKEND_PORT 8000

COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh

# 빌드 이미지에서 생성된 dist 폴더를 nginx 이미지로 복사
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80
ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]
