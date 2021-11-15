package com.sintern.repository;

import com.sintern.domain.entity.CompanyLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LogoRepository extends JpaRepository<CompanyLogo, UUID> {
    Optional<CompanyLogo> findLogoByCompanyId(UUID comapanyId);
}
