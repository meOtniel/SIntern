package com.sintern.api;

import com.sintern.api.request.RegisterStudentRequest;
import com.sintern.api.request.transformer.RegisterStudentTransformer;
import com.sintern.api.response.GetStudentResponse;
import com.sintern.domain.entity.FileEntity;
import com.sintern.service.FileService;
import com.sintern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static com.sintern.api.response.transformer.GetStudentTransformer.transform;

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
    public void studentRegister(@Valid @RequestBody RegisterStudentRequest registerStudentRequest) {
        studentService.addStudent(RegisterStudentTransformer.transform(registerStudentRequest));
    }

    @PostMapping("/upload-cv")
    @ResponseStatus(HttpStatus.OK)
    public void uploadCv(@RequestParam("id") UUID studentId, @RequestParam("file") MultipartFile cv) {
        fileService.save(cv, studentId);
    }

    @GetMapping("/{studentId}/cv")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID studentId) {
        Optional<FileEntity> fileEntityOptional = fileService.getByStudentId(studentId);

        if (fileEntityOptional.isEmpty()) {
            return ResponseEntity.notFound()
                    .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }

    @GetMapping("/{studentID}")
    @ResponseStatus(HttpStatus.OK)
    public GetStudentResponse getStudent(@PathVariable UUID studentID){
        return transform(studentService.findById(studentID));
    }
}
