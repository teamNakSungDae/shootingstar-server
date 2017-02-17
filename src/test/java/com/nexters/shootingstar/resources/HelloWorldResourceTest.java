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

    //private static final ResourceTestRule resourceTestRule = ResourceTestRule.builder().addResource(null).build();
    @Before
    public void setUp() {
        // Init database
        // Seed database
    }

//    @ClassRule
//    public static final ResourceTestRule RULE = ResourceTestRule.builder()
//            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
//            .addResource(null)
//            .build();
    @Test
    public void useJerseyClientBuilder(){

//        Client client = new JerseyClientBuilder().build();
//        Response response = client.target(
//                String.format("http://localhost:8080/hello_world?name=giho"))
//                .request()
//                .get(String.class);

        //assertThat(response.getStatus()).isEqualTo(200);
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
