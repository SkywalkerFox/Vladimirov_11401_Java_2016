package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by Павел on 31.05.2016.
 */
public interface AuthService {
    ResponseEntity<Boolean> logIn(String email, String password);
}
