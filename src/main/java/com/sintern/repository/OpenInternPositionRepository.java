package com.sintern.repository;

import com.sintern.domain.OpenInternPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpenInternPositionRepository extends JpaRepository<OpenInternPosition, UUID> {
}
