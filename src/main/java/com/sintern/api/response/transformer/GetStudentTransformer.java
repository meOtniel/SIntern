package com.sintern.api.response.transformer;

import com.sintern.api.response.GetStudentResponse;
import com.sintern.domain.entity.Student;

public class GetStudentTransformer {

    public static GetStudentResponse transform(Student student) {
        GetStudentResponse getStudentResponse = new GetStudentResponse();
        getStudentResponse.setFirstName(student.getFirstName());
        getStudentResponse.setLastName(student.getLastName());
        getStudentResponse.setDateOfBirth(student.getDateOfBirth());
        getStudentResponse.setPhoneNumber(student.getPhoneNumber());
        getStudentResponse.setEducationDetails(student.getEducationDetails());
        return getStudentResponse;
    }
}
