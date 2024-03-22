# 在完成构建镜像文件后，执行该命令可以构建容器。直接把该命令复制到D:\xiangmu\chatbot-api>目录下执行
docker run -p 8090:8090 --name chatbot-api -d chatbot-api:1.0