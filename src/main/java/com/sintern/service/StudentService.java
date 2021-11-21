package com.sintern.service;

import com.sintern.domain.entity.Student;

import java.util.UUID;

public interface StudentService {

    void addStudent(Student student);

    Student findById(UUID uuid);
}
