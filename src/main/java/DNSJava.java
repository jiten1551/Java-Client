import lombok.extern.log4j.Log4j2;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

@Log4j2
public class DNSJava {
    public static void main(String[] args) {
        System.out.println(digDns("search-him-test-check-29ac375f6f2d41b2b1f757594f1f2e9c.us-east-1.swift.a9.com.", Type.TXT));
    }

    public static Set<String> digDns(String endpoint, int recordType) {
        Set<String> records = new HashSet<>();
        try {
            SimpleResolver resolver = new SimpleResolver();
            Lookup lookup = new Lookup(endpoint, recordType);
            lookup.setResolver(resolver);
            Record[] result = lookup.run();

            if (Lookup.SUCCESSFUL == lookup.getResult() && result.length != 0) {
                for (Record record : result) {
                    records.add(record.rdataToString().replaceAll("\"", ""));
                }
            } else {
                log.error("Route53: record not found, url: {}, type: {}", endpoint, recordType);
            }
        } catch (UnknownHostException | TextParseException e) {
            log.error("Exception occurred while querying name servers", e);
        }
        log.info("Route53: DNS dig on {} resolved to {}", endpoint, records);
        return records;
    }


}
