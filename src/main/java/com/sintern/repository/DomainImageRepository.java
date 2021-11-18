package com.sintern.repository;

import com.sintern.domain.entity.DomainImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DomainImageRepository extends JpaRepository<DomainImage, UUID> {
    Optional<DomainImage> findDomainImageByDomainId(UUID domainId);
}
