package com.sintern.service;

import org.springframework.stereotype.Service;

public interface EncryptionService {
    public String encodePassword(String password);
}
