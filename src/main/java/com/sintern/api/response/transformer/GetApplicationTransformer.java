package com.sintern.api.response.transformer;

import com.sintern.api.response.GetApplicationByInternPositionResponse;
import com.sintern.domain.entity.Application;
import com.sintern.domain.entity.Student;

public class GetApplicationTransformer {

    public static GetApplicationByInternPositionResponse transform(Application application, Student student, byte[] cv) {
        GetApplicationByInternPositionResponse getApplicationByInternPositionResponse = new GetApplicationByInternPositionResponse();
        getApplicationByInternPositionResponse.setFirstName(student.getFirstName());
        getApplicationByInternPositionResponse.setLastName(student.getLastName());
        getApplicationByInternPositionResponse.setEducationDetails(student.getEducationDetails());
        getApplicationByInternPositionResponse.setPhoneNumber(student.getPhoneNumber());
        getApplicationByInternPositionResponse.setEmail(student.getEmail());
        getApplicationByInternPositionResponse.setDateOfBirth(student.getDateOfBirth());
        getApplicationByInternPositionResponse.setCv(cv);
        getApplicationByInternPositionResponse.setDescription(application.getDescription());
        getApplicationByInternPositionResponse.setDateOfSubmission(application.getDateOfSubmission());
        return getApplicationByInternPositionResponse;
    }
}
