package com.sintern.api;

import com.sintern.domain.Student;
import com.sintern.service.OpenInternPositionService;
import com.sintern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/Student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/Register")
    public void studentRegister(@RequestBody  Student student) {
        studentService.addStudent(student);
    }
}
