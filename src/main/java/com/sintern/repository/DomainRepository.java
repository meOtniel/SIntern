package com.sintern.repository;

import com.sintern.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DomainRepository extends JpaRepository<Domain, UUID> {
}
