package com.sintern.service;
import org.springframework.stereotype.Service;

public interface EncryptionService {

    String encodePassword(String password);
}
