package com.sintern.api.request;

import java.util.UUID;

public class AddApplicationRequest {

    private String description;
    private UUID openInternPositionID;
    private UUID studentID;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getOpenInternPositionID() {
        return openInternPositionID;
    }

    public void setOpenInternPositionID(UUID openInternPositionID) {
        this.openInternPositionID = openInternPositionID;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }
}
