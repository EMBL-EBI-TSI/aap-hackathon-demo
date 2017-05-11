package uk.ac.ebi.tsc.aap.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neilg on 11/05/2017.
 */
@Service
public class LocalTokenServiceImpl implements LocalTokenService {

    @Value("${aap.token.url}")
    String aapTokenUrl;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> getAAPTokenResponse(String username, String password) {
        HttpEntity<String> request = new HttpEntity<String>(getHttpHeaders(username,password));
        final ResponseEntity<String> exchange = restTemplate.exchange(aapTokenUrl, HttpMethod.GET, request, String.class);
        return exchange;
    }

    @Override
    public String getAAPToken(String username, String password) {
        final ResponseEntity<String> aapTokenResponse = getAAPTokenResponse(username, password);
        return aapTokenResponse.getBody();
    }

    private static HttpHeaders getHttpHeaders (String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + Base64Coder.encodeString(username + ":" + password));
        return headers;
    }
}
