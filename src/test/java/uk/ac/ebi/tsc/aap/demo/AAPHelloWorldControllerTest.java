package uk.ac.ebi.tsc.aap.demo;

import com.mashape.unirest.http.utils.Base64Coder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.tsc.aap.client.repo.DomainService;
import uk.ac.ebi.tsc.aap.demo.service.LocalTokenService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neilg on 11/05/2017.
 */
@ActiveProfiles("aap_production")
public class AAPHelloWorldControllerTest extends HelloWorldControllerTest {

    @Autowired
    LocalTokenService localTokenService;

    @Value("${aap.username}")
    String username;

    @Value("${aap.password}")
    String password;

    @Autowired
    DomainService domainService;

    @Override
    protected Map<String, String> createStandardGetHeaders() {
        Map<String, String> headerMap = new HashMap<>();
        String token = localTokenService.getAAPToken(username,password);
        headerMap.put("Authorization", "Bearer " + token);
        return headerMap;
    }

    @Override
    public void adminPage() throws Exception {
        //super.adminPage();
    }
}
