FROM jeffwang/tomcat
MAINTAINER "Jeff Wang<jeff.wang@chinasystems.com>"
ADD dockerweb.war /usr/local/tomcat/webapps/
RUN groupadd -r tomcat && useradd -r -g tomcat tomcat
RUN chmod -R 777 /usr/local/tomcat/
USER tomcat
RUN mkdir -p /tmp/cslogs/dockerweb
RUN chmod 777 -R /tmp/cslogs/dockerweb/
WORKDIR /usr/local/tomcat/bin
CMD ["catalina.sh", "run"]


