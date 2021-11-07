package com.sintern.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionServiceImpl implements EncryptionService {

    public String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        return encodedPassword;
    }
}
