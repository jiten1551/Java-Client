# Java-Client

To reproduce https://github.com/opensearch-project/OpenSearch/issues/3640:

Create openSearch domain in (AWS) which support IAM based AuthN/AuthZ.

Update the value of `host` and `region` in [RESTClientTest.java](/src/main/java/RESTClientTest.java#L27) to your endpoint.

```
export AWS_ACCESS_KEY_ID=
export AWS_SECRET_ACCESS_KEY=
export AWS_SESSION_TOKEN=

mvn install
mvn compile exec:java -Dexec.mainClass="RESTClientTest"
```

Toggle [`.setCompressionEnabled(true/false)`](src/main/java/RESTClientTest.java#L103).

With compression disabled the code will create an index, add a document, then cleanup.

With compression enabled the request will fail with a 403 forbidden and an invalid signature error.

```
{"message":"The request signature we calculated does not match the signature you provided. Check your AWS Secret Access Key and signing method. Consult the service documentation for details."}
```
