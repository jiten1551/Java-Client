# Java-Client

1. step to repro issue: https://github.com/opensearch-project/OpenSearch/issues/3640

2. signing sigv4 for streams https://docs.aws.amazon.com/AmazonS3/latest/API/sigv4-streaming.html

3. for (a) with content-length replace rest-client ( patched jar https://github.com/jiten1551/Java-Client/tree/master/src/main/resources) jar in ~/.m2 repo of local workspace (jar contains fix that uses content length instead of transfer-encoding) and re-run the RestClientTest.java file
4. for (b) with transfer-encoding use original rest-client jar that use transfer encoding when compression enabled.

### NOTE: for both to have ```x-amz-decoded-content-length``` add this header edit https://github.com/jiten1551/Java-Client/blob/master/src/main/java/com/amazonaws/http/AWSRequestSigningApacheInterceptor.java#L181


