rm dockerweb.war
docker image rm -f jeffwang/tomcat-dockerweb:1.0
cp ../../target/dockerweb-1.0.0.war dockerweb.war
sudo docker build -t jeffwang/tomcat-dockerweb:jdk8 .
