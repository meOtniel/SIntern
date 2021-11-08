package com.sintern.security.service;

import com.sintern.exception.InvalidException;
import com.sintern.repository.CompanyRepository;
import com.sintern.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SUserDetailsService implements UserDetailsService {

    StudentRepository studentRepository;
    CompanyRepository companyRepository;
//    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (studentRepository.existsByEmail(s)) {
            return studentRepository.findByEmail(s);
        } else if (companyRepository.existsByEmail(s)) {
            return companyRepository.findByEmail(s);
        } else {
            throw new UsernameNotFoundException("Invalid credentials!");
        }
    }

//    public UserDetails findByEmailAndPassword(String email, String password) {
//        if (studentRepository.existsByEmailAndPassword(email, encoder.encode(password))) {
//            return studentRepository.findByEmail(email);
//        } else if (companyRepository.existsByEmailAndPassword(email, encoder.encode(password))) {
//            return companyRepository.findByEmail(email);
//        }
//        else {
//            throw new InvalidException("Invalid credentials!");
//        }
//    }
}