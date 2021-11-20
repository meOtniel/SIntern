package com.sintern.service;

import com.sintern.domain.entity.DomainImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

public interface DomainImageService {

    Optional<DomainImage> getDomainImageByDomainId(UUID domainId);

    void save(MultipartFile file, UUID domainId);
}
