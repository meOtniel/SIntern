package com.sintern.service;

import com.sintern.domain.Student;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private EncryptionService encryptionService = new EncryptionServiceImpl();

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        String encodedPassword = encryptionService.encodePassword(student.getPassword());
        student.setPassword(encodedPassword);
        studentRepository.save(student);
    }

}
