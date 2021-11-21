package com.sintern.service;

import com.sintern.domain.entity.Student;

import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    void addStudent(Student student);

    Optional<Student> findById(UUID uuid);
}
