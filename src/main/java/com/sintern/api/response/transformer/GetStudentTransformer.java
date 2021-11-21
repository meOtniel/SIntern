package com.sintern.api.response.transformer;

import com.sintern.api.response.GetStudentResponse;
import com.sintern.domain.entity.Student;

public class GetStudentTransformer {

    public static GetStudentResponse transform(Student companyRegisterRequest) {
        GetStudentResponse getStudentResponse = new GetStudentResponse();
        getStudentResponse.setFirstName(companyRegisterRequest.getFirstName());
        getStudentResponse.setLastName(companyRegisterRequest.getLastName());
        getStudentResponse.setDateOfBirth(companyRegisterRequest.getDateOfBirth());
        getStudentResponse.setPhoneNumber(companyRegisterRequest.getPhoneNumber());
        getStudentResponse.setEducationDetails(companyRegisterRequest.getEducationDetails());
        return getStudentResponse;
    }
}
