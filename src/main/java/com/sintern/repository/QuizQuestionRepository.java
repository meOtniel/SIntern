package com.sintern.repository;

import com.sintern.domain.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, UUID> {
}
