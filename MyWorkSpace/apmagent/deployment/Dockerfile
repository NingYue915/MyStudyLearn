FROM jeffwang/tomcat:jdk14
LABEL maintainer="Jeff Wang<jeff.wang@chinasystems.com>"
ADD setenv.sh  /usr/local/tomcat/bin/
ADD catalina.sh /usr/local/tomcat/bin/
ADD elastic-apm-agent-1.18.0.RC1.jar /usr/local/tomcat/lib/
RUN chmod -R 777 /bin/ && chmod -R 777 /usr/local/tomcat/bin/ 




