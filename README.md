# WebServerWithSpring
Tomcat + Spring

1)Необходимо скачать <a href="https://tomcat.apache.org/download-90.cgi">apache tomcat</a>.

2)Перейти в <tomcat_home>/conf/server.xml и добавить:
```
<Resource name="jdbc/Users"
              auth="Container"
              type="javax.sql.DataSource"
              driverClassName="org.h2.Driver"
              url="jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"
              username="root"
              password="root"/>
```

Перейти в <tomcat_home>/conf/context.xml и добавить:
```
    <ResourceLink
            name="jdbc/Users"
            global="jdbc/Users"
            type="javax.sql.DataSource"/>
 ```       
3) Сборка war файла

4) Перемещение war файла в папку <tomcat_home>/webapps/

5) Запуск сервера tomcat
