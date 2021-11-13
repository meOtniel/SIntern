package com.sintern.api;

import com.sintern.domain.entity.FileEntity;
import com.sintern.domain.entity.Student;
import com.sintern.service.FileService;
import com.sintern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final FileService fileService;

    @Autowired
    public StudentController(StudentService studentService, FileService fileService) {
        this.studentService = studentService;
        this.fileService = fileService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void studentRegister(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PostMapping("/upload-cv")
    @ResponseStatus(HttpStatus.OK)
    public void uploadCv(@RequestParam("id") UUID studentId, @RequestParam("file") MultipartFile cv) {
        fileService.save(cv, studentId);
    }

    @GetMapping("/{studentId}/cv")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID studentId) {
        Optional<FileEntity> fileEntityOptional = fileService.getByStudentId(studentId);

        if (!fileEntityOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }

}
