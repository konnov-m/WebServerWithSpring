# WebServerWithSpring
Tomcat + Spring

Перейти в <tomcat_home>/conf/server.xml и добавить:
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
