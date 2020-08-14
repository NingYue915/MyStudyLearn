FROM tomcat:9.0.37-jdk8
LABEL maintainer="Jeff Wang<jeff.wang@chinasystems.com>"
RUN groupadd -r tomcat && useradd -r -m -g tomcat tomcat
ADD dockerweb.war /usr/local/tomcat/webapps/
RUN chmod -R 777 /usr/local/tomcat/ 
USER tomcat
ENV UMASK="0000"
WORKDIR /usr/local/tomcat/bin
CMD ["catalina.sh", "run"]