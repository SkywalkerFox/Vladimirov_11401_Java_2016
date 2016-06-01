package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Павел on 31.05.2016.
 */
public class AuthServiceImpl implements AuthService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<Boolean> logIn(String email, String password) {
        MultiValueMap<String, Object> loginParameters = new LinkedMultiValueMap<>();
        loginParameters.add("email", email);
        loginParameters.add("password", password);
        System.out.println(loginParameters.size());
        return restTemplate.postForEntity("http://localhost:8080/api/login", loginParameters, Boolean.class);
    }
}
