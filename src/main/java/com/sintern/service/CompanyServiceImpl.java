package com.sintern.service;

import com.sintern.domain.Company;
import com.sintern.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private EncryptionService encryptionService= new EncryptionServiceImpl();

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void addCompany(Company company){
        String encodedPassword = encryptionService.encodePassword(company.getPassword());
        company.setPassword(encodedPassword);
        companyRepository.save(company);
    }
}