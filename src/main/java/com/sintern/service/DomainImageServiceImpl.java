package com.sintern.service;

import com.sintern.domain.entity.Domain;
import com.sintern.domain.entity.DomainImage;
import com.sintern.exception.DomainImageException;
import com.sintern.repository.DomainImageRepository;
import com.sintern.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class DomainImageServiceImpl implements DomainImageService {

    private final DomainImageRepository domainImageRepository;
    private final DomainRepository domainRepository;

    @Autowired
    public DomainImageServiceImpl(DomainImageRepository domainImageRepository, DomainRepository domainRepository) {
        this.domainImageRepository = domainImageRepository;
        this.domainRepository = domainRepository;
    }

    @Override
    @Transactional
    public Optional<DomainImage> getDomainImageByDomainId(UUID domainId) {
        return domainImageRepository.findDomainImageByDomainId(domainId);
    }

    @Override
    public void save(MultipartFile image, UUID domainId) {
        Domain domain = domainRepository.getById(domainId);
        DomainImage domainImage = new DomainImage();
        domainImage.setName(StringUtils.cleanPath(image.getOriginalFilename()));
        domainImage.setContentType(image.getContentType());
        try {
            domainImage.setData(image.getBytes());
        } catch (IOException exception) {
            throw new DomainImageException("Could not save image " + image.getName());
        }
        domainImage.setSize(image.getSize());
        domainImage.setDomain(domain);
        domainImageRepository.save(domainImage);
    }
}
