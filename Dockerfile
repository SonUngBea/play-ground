From tomcat:8-jre8
RUN rm -rf /usr/local/tomcat/webapps/ROOT
ADD ./play-ground-web/build/libs/play-ground-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 80