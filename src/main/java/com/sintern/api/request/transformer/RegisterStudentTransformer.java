package com.sintern.api.request.transformer;

import com.sintern.api.request.RegisterStudentRequest;
import com.sintern.domain.entity.EducationDetails;
import com.sintern.domain.entity.Student;
import com.sintern.domain.enums.FacultyType;
import com.sintern.domain.enums.SpecializationType;
import com.sintern.domain.enums.UniversityType;

public class RegisterStudentTransformer {

    public static Student transform(RegisterStudentRequest registerStudentRequest) {
        Student student = new Student();
        student.setFirstName(registerStudentRequest.getFirstName());
        student.setLastName(registerStudentRequest.getLastName());
        student.setEmail(registerStudentRequest.getEmail());
        student.setPassword(registerStudentRequest.getPassword());
        student.setDateOfBirth(registerStudentRequest.getDateOfBirth());
        student.setPhoneNumber(registerStudentRequest.getPhoneNumber());

        EducationDetails educationDetails = new EducationDetails();
        educationDetails.setSpecialization(SpecializationType.valueOf(registerStudentRequest.getSpecialization()));
        educationDetails.setFaculty(FacultyType.valueOf(registerStudentRequest.getFaculty()));
        educationDetails.setUniversity(UniversityType.valueOf(registerStudentRequest.getUniversity()));
        educationDetails.setYearOfStudy(registerStudentRequest.getYearOfStudy());

        student.setEducationDetails(educationDetails);
        educationDetails.setStudent(student);
        return student;
    }
}
