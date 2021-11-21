package com.sintern.security.utils;

import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.Student;
import com.sintern.exception.InvalidTokenException;
import com.sintern.repository.CompanyRepository;
import com.sintern.repository.StudentRepository;
import com.sintern.security.jwt.JwtUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationUtils {

    JwtUtil jwtUtil;
    StudentRepository studentRepository;
    CompanyRepository companyRepository;

    public UserDTO validateToken(String token) {
        String email = jwtUtil.extractUsername(token);
        if (studentRepository.existsByEmail(email)) {
            Student student = studentRepository.findByEmail(email);
            return UserDTO.builder()
                    .email(email)
                    .id(student.getId().toString())
                    .type("student")
                    .build();
        } else if (companyRepository.existsByEmail(email)) {
            Company company = companyRepository.findByEmail(email);
            return UserDTO.builder()
                    .email(email)
                    .id(company.getId().toString())
                    .type("company")
                    .build();
        }
        throw new InvalidTokenException("Invalid token!");
    }

    @Value
    @Builder(toBuilder = true)
    public static class UserDTO {
        String email;
        String id;
        String type;
    }
}
