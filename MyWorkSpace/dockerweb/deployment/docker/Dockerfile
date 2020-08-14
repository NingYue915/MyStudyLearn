FROM tomcat:9.0.37-jdk8
LABEL maintainer="Jeff Wang<jeff.wang@chinasystems.com>"
RUN groupadd -r tomcat && useradd -r -m -g tomcat tomcat
ADD profile /etc/
ADD dockerweb.war /usr/local/tomcat/webapps/
RUN chmod -R 777 /usr/local/tomcat/ && chmod -R 777 /usr/local/tomcat/bin
USER tomcat
WORKDIR /usr/local/tomcat/bin
CMD ["catalina.sh", "run"]