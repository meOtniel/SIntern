package com.sintern.repository;

import com.sintern.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Company findCompanyByEmail(String email);
}
