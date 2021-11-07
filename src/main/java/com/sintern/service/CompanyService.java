package com.sintern.service;

import com.sintern.domain.Company;
import com.sintern.domain.OpenInternPosition;
import com.sintern.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    void addCompany(Company company);
}
