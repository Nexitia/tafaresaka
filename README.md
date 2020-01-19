
Messaging client based on JSOAGGER.

# Prerequisites

1. Latest version of maven
2. Java version 11 or later
3. A web browser


# Download

```
> mkdir taferasaka 

> cd taferasaka

> git checkout https://github.com/jsoagger/tafaresaka.git
```

# Build

Profile npm-install will installe node.js and dependencies on he project. 

The profile npm-install should be run only the first time project install.


```
> mvn clean install -P npm-install
```

# Run

## 1. Start h2 database

```
> chmod 777 ./_docker-compose/h2/bin/h2.sh 

> ./_docker-compose/h2/bin/h2.sh &
```

Be aware, the URL inside the h2 console must be:

```
jdbc:h2:tcp://localhost/foundation;MVCC=TRUE;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1
```

## 2. Start the backend server

```
> java -jar ./tafaresaka-microservice/target/tafamicroservice-1.0.0-SNAPSHOT-sb.jar --spring.config.location=file:_docker-compose/server/application-local.properties 
```

## 3. Mobile client UI

```
> java -jar ./tafaresaka-mobile/target/tafaresaka-clientmobile-1.0.0-SNAPSHOT.jar  --jsoagger.client.mode=simul_mobile
```



## 4. web client UI

Must be ran unde tafaresaka-web directory:

```
> cd tafaresaka-web
 
> REACT_APP_BACKEND_HOST=http://localhost:8080/jsoagger/serv/core npm start
```

And then browse htttp://localhost:3000/#home







