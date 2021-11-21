package com.sintern.repository;

import com.sintern.domain.entity.EducationDetails;
import com.sintern.domain.enums.UniversityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EducationDetailsRepository extends JpaRepository<EducationDetails, UUID> {
}