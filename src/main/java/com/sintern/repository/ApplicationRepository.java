package com.sintern.repository;

import com.sintern.domain.entity.Application;
import com.sintern.domain.entity.OpenInternPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    Application findApplicationByStudentIdAndOpenInternPositionId(UUID studentID, UUID openInternPositionID);

    List<Application> findApplicationByOpenInternPosition(OpenInternPosition openInternPositionID);
}
