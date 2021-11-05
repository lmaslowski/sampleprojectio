### Sample project

#### HeapDump
```java
mvn clean install -DskipTests && java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heapdump.bin -jar target/sampleproject-1.0-SNAPSHOT.jar --server.port=8080
```
