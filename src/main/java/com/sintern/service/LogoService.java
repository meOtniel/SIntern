package com.sintern.service;

import com.sintern.domain.entity.CompanyLogo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

public interface LogoService {

    Optional<CompanyLogo> getLogoByCompanyId(UUID companyId);

    void save(MultipartFile file, UUID companyId);
}
