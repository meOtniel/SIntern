package com.sintern.service;

import com.sintern.domain.entity.Application;
import com.sintern.domain.entity.OpenInternPosition;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {

    void addApplication(UUID studentID, UUID openInternPositionID, String description);

    List<Application> findApplicationsByOpenInternPosition(OpenInternPosition openInternPositionID);
}
