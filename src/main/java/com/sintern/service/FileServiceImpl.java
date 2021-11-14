package com.sintern.service;

import com.sintern.domain.entity.FileEntity;
import com.sintern.domain.entity.Student;
import com.sintern.exception.SaveCvFailedException;
import com.sintern.repository.FileRepository;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, StudentRepository studentRepository) {
        this.fileRepository = fileRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(MultipartFile file, UUID studentId) {
        Student student = studentRepository.getById(studentId);
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        try {
            fileEntity.setData(file.getBytes());
        } catch (IOException exception) {
            throw new SaveCvFailedException("Could not save file " + file.getName());
        }
        fileEntity.setSize(file.getSize());
        fileEntity.setStudent(student);

        fileRepository.save(fileEntity);
    }

    @Override
    @Transactional
    public Optional<FileEntity> getByStudentId(UUID studentId) {
        return fileRepository.findByStudentId(studentId);
    }
}
