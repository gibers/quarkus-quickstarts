package org.acme.getting.started.testing;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@QuarkusTest
public class StaticContentTest {

    @TestHTTPResource("index.html")
    URL url;

    @TestHTTPEndpoint(GreetingResource.class)
    @TestHTTPResource("/greeting/bertrand")
    URL url1;

    @Test
    public void testIndexHtml() throws IOException {
        try (InputStream in = url.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertTrue(contents.contains("<title>Testing Guide</title>"));
        }
    }

    @Test
    public void testIndexHtml1() throws IOException {
        try (InputStream in = url1.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("hello bertrand", contents);
        }
    }

    @Test
    void test1() {
        System.out.println("test1 OK");
    }

}
