package com.sintern.service;

import com.sintern.domain.entity.Application;
import com.sintern.domain.entity.FileEntity;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.entity.Student;
import com.sintern.exception.CVNotFoundException;
import com.sintern.exception.EntityNotFoundException;
import com.sintern.repository.ApplicationRepository;
import com.sintern.repository.FileRepository;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final OpenInternPositionRepository openInternPositionRepository;
    private final FileRepository fileRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  StudentRepository studentRepository,
                                  OpenInternPositionRepository openInternPositionRepository,
                                  FileRepository fileRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.openInternPositionRepository = openInternPositionRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    @Transactional
    public void addApplication(UUID studentID, UUID openInternPositionID, String description) {
        Student student = studentRepository.findStudentById(studentID);
        if(student == null)
            throw new EntityNotFoundException("Student with given id does not exist!");

        Optional<FileEntity> fileEntity = fileRepository.findByStudentId(studentID);
        if(fileEntity.isEmpty())
            throw new CVNotFoundException("Student does not have attached a CV!");

        OpenInternPosition openInternPosition = openInternPositionRepository.findOpenInternPositionById(openInternPositionID);
        if(openInternPosition == null)
            throw new EntityNotFoundException("Position with given id does not exist!");

        Application applicationFound = applicationRepository.findApplicationByStudentIdAndOpenInternPositionId(studentID, openInternPositionID);
        if(applicationFound != null){
            applicationFound.setStudent(student);
            applicationFound.setOpenInternPosition(openInternPosition);
            applicationFound.setDateOfSubmission(LocalDateTime.now());
            applicationFound.setDescription(description);

            applicationRepository.save(applicationFound);
        }
        else{
        Application application = new Application();
        application.setStudent(student);
        application.setOpenInternPosition(openInternPosition);
        application.setDateOfSubmission(LocalDateTime.now());
        application.setDescription(description);

        applicationRepository.save(application);
        }
    }
}