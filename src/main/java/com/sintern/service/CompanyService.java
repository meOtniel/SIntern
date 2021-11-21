package com.sintern.service;

import com.sintern.domain.entity.Company;

import java.util.UUID;

public interface CompanyService {

    void addCompany(Company company);

    Company findByID(UUID uuid);
}