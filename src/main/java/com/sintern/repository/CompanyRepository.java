package com.sintern.repository;

import com.sintern.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Company findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);
}