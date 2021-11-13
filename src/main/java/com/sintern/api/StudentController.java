package com.sintern.api;

import com.sintern.domain.entity.Student;
import com.sintern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void studentRegister(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }
}
