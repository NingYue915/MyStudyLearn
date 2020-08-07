docker image rm -f jeffwang/tomcat-apmagent:latest
rm apmagent.war || true
cp ../target/apmagent-1.0.0.war apmagent.war
docker build -t jeffwang/tomcat-apmagent .
