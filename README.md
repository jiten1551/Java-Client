# Java-Client

To reproduce https://github.com/opensearch-project/OpenSearch/issues/3640:

Create openSearch domain in (AWS) which support IAM based AuthN/AuthZ.

```
export AWS_ACCESS_KEY_ID=
export AWS_SECRET_ACCESS_KEY=
export AWS_SESSION_TOKEN=

mvn install
mvn compile exec:java -Dexec.mainClass="RESTClientTest"
```

Toggle [`.setCompressionEnabled(true/false)`](https://github.com/dblock/Java-Client/blob/master/src/main/java/RESTClientTest.java#L103).