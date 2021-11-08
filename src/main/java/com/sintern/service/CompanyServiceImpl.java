package com.sintern.service;

import com.sintern.domain.Company;
import com.sintern.exception.ExistentEmailException;
import com.sintern.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Company companyFoundByEmail=companyRepository.findByEmail(company.getEmail());
        if(companyFoundByEmail!=null)
        {
            throw new ExistentEmailException("There is already a company with this email!");
        }else {
            String encodedPassword = encryptionService.encodePassword(company.getPassword());
            company.setPassword(encodedPassword);
            companyRepository.save(company);
        }
    }
}