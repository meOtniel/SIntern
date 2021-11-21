package com.sintern.service;

import java.util.UUID;

public interface ApplicationService {

    void addApplication(UUID studentID, UUID openInternPositionID, String description);
}
