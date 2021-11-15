package com.sintern.service;

import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.CompanyLogo;
import com.sintern.exception.LogoCompanyException;
import com.sintern.repository.CompanyRepository;
import com.sintern.repository.LogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class LogoServiceImpl implements LogoService {

    private final LogoRepository logoRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public LogoServiceImpl(LogoRepository logoRepository, CompanyRepository companyRepository) {
        this.logoRepository = logoRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public Optional<CompanyLogo> getLogoByCompanyId(UUID companyId) {
        return logoRepository.findLogoByCompanyId(companyId);
    }

    @Override
    public void save(MultipartFile image, UUID companyId) {
        Company company = companyRepository.getById(companyId);
        CompanyLogo companyLogo = new CompanyLogo();
        companyLogo.setName(StringUtils.cleanPath(image.getOriginalFilename()));
        companyLogo.setContentType(image.getContentType());
        try {
            companyLogo.setData(image.getBytes());
        } catch (IOException exception) {
            throw new LogoCompanyException("Could not save image " + image.getName());
        }
        companyLogo.setSize(image.getSize());
        companyLogo.setCompany(company);

        logoRepository.save(companyLogo);
    }
}
