package uk.ac.ebi.tsc.aap.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.tsc.aap.demo.HelloWorldController;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by neilg on 11/05/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloWorldController.class)
public class LocalTokenServiceTest {

    @Value("${aap.username}")
    String username;

    @Value("${aap.password}")
    String password;

    @Autowired
    LocalTokenService localTokenService;

    @Test
    public void getAAPTokenResponse() throws Exception {
        final ResponseEntity<String> aapTokenResponse = localTokenService.getAAPTokenResponse(username, password);
        assertThat(aapTokenResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

}