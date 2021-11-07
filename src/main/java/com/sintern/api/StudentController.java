package com.sintern.api;

import com.sintern.domain.Student;
import com.sintern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public void studentRegister(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}
