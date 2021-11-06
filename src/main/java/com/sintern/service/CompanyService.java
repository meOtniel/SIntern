package com.sintern.service;

import com.sintern.domain.Company;
import com.sintern.domain.OpenInternPosition;
import com.sintern.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void addCompany(Company company){
        String encodedPassword=encodePassword(company.getPassword());
        company.setPassword(encodedPassword);
        companyRepository.save(company);
    }

    public String encodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);

    }

}
