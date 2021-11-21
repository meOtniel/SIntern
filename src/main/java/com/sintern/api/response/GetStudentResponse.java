package com.sintern.api.response;

import com.sintern.domain.entity.EducationDetails;

import java.time.LocalDate;

public class GetStudentResponse  {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private EducationDetails educationDetails;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EducationDetails getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(EducationDetails educationDetails) {
        this.educationDetails = educationDetails;
    }
}
