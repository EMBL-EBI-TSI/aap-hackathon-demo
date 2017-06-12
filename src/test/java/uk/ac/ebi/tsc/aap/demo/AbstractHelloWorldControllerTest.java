package uk.ac.ebi.tsc.aap.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by neilg on 04/05/2017.
 */
public abstract class AbstractHelloWorldControllerTest {

    @LocalServerPort
    private int port;
    private String rootUri;

    public static String DEFAULT_USER = "username";
    public static String DEFAULT_ADMIN = "admin";
    public static String DEFAULT_PASSWORD = "password";

    Map<String, String> getHeaders = new HashMap<>();

    @Before
    public void setup() throws URISyntaxException {
        rootUri = "http://localhost:" + port + "";
    }



    public void welcomePage() throws Exception {
        HttpResponse response = Unirest.get(rootUri)
                .headers(createStandardGetHeaders())
                .asString();
        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    }


    public void hello() throws Exception {
        HttpResponse response = Unirest.get(rootUri + "/hello")
                .headers(createStandardGetHeaders())
                .asString();
        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    }


    public void adminPage() throws Exception {
        HttpResponse response = Unirest.get(rootUri + "/admin")
                .headers(createStandardGetHeaders())
                .asString();
        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    }

    protected Map<String, String> createStandardGetHeaders() {
        Map<String, String> h = new HashMap<>();
        h.put("Authorization", "Basic " + Base64Coder.encodeString(DEFAULT_ADMIN + ":" + DEFAULT_PASSWORD));
        return h;
    }

}