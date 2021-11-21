package com.sintern.service;

import com.sintern.domain.entity.Student;
import com.sintern.exception.ExistentEmailException;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final EncryptionService encryptionService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, EncryptionService encryptionService) {
        this.studentRepository = studentRepository;
        this.encryptionService = encryptionService;
    }

    public void addStudent(Student student) {
        Student studentFoundByEmail = studentRepository.findByEmail(student.getEmail());
        if (studentFoundByEmail != null){
            System.out.println(studentFoundByEmail);
            throw new ExistentEmailException("There is already a student with this email!");
        } else {
            String encodedPassword = encryptionService.encodePassword(student.getPassword());
            student.setPassword(encodedPassword);
            studentRepository.save(student);
        }
    }

    public Optional<Student> findById(UUID uuid) {
        return studentRepository.findById(uuid);
    }
}
