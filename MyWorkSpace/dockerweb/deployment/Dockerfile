FROM jeffwang/tomcat
MAINTAINER "Jeff Wang<jeff.wang@chinasystems.com>"
ADD dockerweb.war /usr/local/tomcat/webapps/
RUN mkdir -p /cslogs/dockerweb
RUN chown 777 /cslogs/dockerweb 
CMD ["catalina.sh", "run"]


