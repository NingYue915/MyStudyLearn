export CATALINA_OPTS="$CATALINA_OPTS -javaagent:/usr/local/tomcat/lib/elastic-apm-agent-1.18.0.RC1.jar"
export CATALINA_OPTS="$CATALINA_OPTS -Delastic.apm.service_name=my-apmagent-service"
export CATALINA_OPTS="$CATALINA_OPTS -Delastic.apm.application_packages=com.cs.jeff.apmagent"
export CATALINA_OPTS="$CATALINA_OPTS -Delastic.apm.server_urls=http://172.17.0.2:31820"