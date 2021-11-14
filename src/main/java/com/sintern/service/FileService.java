package com.sintern.service;

import com.sintern.domain.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

public interface FileService {
    void save(MultipartFile file, UUID studentId);

    Optional<FileEntity> getByStudentId(UUID studentId);
}
