rm dockerweb.war
cp /home/jeff/GitHub/MyStudyLearn/MyWorkSpace/dockerweb/target/dockerweb-1.0.0.war dockerweb.war
sudo docker build -t jeffwang/tomcat-dockerweb .
