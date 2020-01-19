@java -cp "h2-1.4.197.jar;%H2DRIVERS%;%CLASSPATH%" org.h2.tools.Console %* -webAllowOthers -tcpAllowOthers -baseDir ./_docker-compose/data/
@if errorlevel 1 pause