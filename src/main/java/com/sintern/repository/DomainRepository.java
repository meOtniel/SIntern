package com.sintern.repository;

import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DomainRepository extends JpaRepository<Domain, UUID> {

    List<Domain> findByDomainType(DomainType domainType);
}
