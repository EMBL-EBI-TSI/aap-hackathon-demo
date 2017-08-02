package uk.ac.ebi.tsc.aap.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by neilg on 24/05/2017.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class LocalHelloWorldControllerTest extends AbstractHelloWorldControllerTest {

    @Test
    @Override
    public void welcomePage() throws Exception {
        super.welcomePage();
    }

    @Test
    @Override
    public void hello() throws Exception {
        super.hello();
    }

    @Override
    public void adminPage() throws Exception {
        super.adminPage();
    }
}
