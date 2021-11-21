package com.sintern.service;

import com.sintern.domain.entity.Company;

import java.util.Optional;
import java.util.UUID;

public interface CompanyService {

    void addCompany(Company company);

    Optional<Company> findByID(UUID uuid);
}