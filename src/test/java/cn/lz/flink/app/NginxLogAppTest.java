package cn.lz.flink.app;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NginxLogAppTest {
    @Test
    public void test() {
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
        final Grok grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");

        /* Line of log to match */
        String log = "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";

        Match gm = grok.match(log);
        /* Get the map with matches */
        final Map<String, Object> capture = gm.capture();
        capture.size();
    }

    @Test
    public void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
//        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        LocalDateTime datetime = LocalDateTime.parse("17/May/2015:08:05:32 +0000", dateTimeFormatter);
        System.out.println(datetime);
    }
}