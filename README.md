# webpractice

#列初始建置的說明
spring help init

#列出相性可用的模組
spring  init --list

#產生名為my-web的網頁應用程式
spring init -d=web,jdbc,mysql,websocket --build=maven  --packaging=war   --java-version=1.8   my-web

