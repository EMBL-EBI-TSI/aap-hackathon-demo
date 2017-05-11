package uk.ac.ebi.tsc.aap.demo.service;


import org.springframework.http.ResponseEntity;

/**
 * Created by neilg on 11/05/2017.
 */
public interface LocalTokenService {
    public ResponseEntity<String> getAAPTokenResponse (String username, String password);
    public String getAAPToken (String username, String password);
}
