package com.sintern.repository;

import com.sintern.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}
