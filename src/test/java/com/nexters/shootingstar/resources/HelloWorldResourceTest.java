package com.nexters.shootingstar.resources;

import com.nexters.shootingstar.ResourceTest;
import com.sun.org.apache.xml.internal.utils.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kwongiho on 2017. 2. 10..
 */
public class HelloWorldResourceTest extends ResourceTest {
    @Before
    public void setUp() {
        // Init database
        // Seed database
    }

    @Test
    public void testSayHello() throws IOException {
        URI uri = new URI("http://localhost:8080/hello_world?name=giho");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(String.valueOf(uri));
        HttpResponse res = httpClient.execute(httpGet);
        HttpEntity entity = res.getEntity();

        String content = EntityUtils.toString(entity);
        assertThat(content).isEqualTo("hello! giho");
        assertThat(content).isNotEqualTo("hello! clsan");
    }

    @Test
    public void testSayHelloWithNullName() throws IOException {
    }
}
