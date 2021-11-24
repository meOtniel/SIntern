package com.sintern.repository;

import com.sintern.domain.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizRepository extends JpaRepository<Quiz, UUID> {
    Quiz findByOpenInternPositionId(UUID openInternPositionId);
}
