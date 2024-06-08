FROM tomcat:9.0-alpine

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/mf-second.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["Catalina.sh", "run"]

