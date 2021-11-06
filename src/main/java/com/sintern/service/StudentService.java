package com.sintern.service;

import com.sintern.domain.Student;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        String encodedPassword = encodePassword(student.getPassword());
        student.setPassword(encodedPassword);
        studentRepository.save(student);
    }

    public String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        return encodedPassword;
    }
}
