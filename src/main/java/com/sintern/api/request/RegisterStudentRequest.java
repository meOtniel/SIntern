package com.sintern.api.request;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class RegisterStudentRequest {

    @NotNull(message = "First Name is required")
    @NotBlank(message = "First Name is required")
    @Size(min = 2, max = 100, message = "First Name should have between 2 and 100 characters")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @NotBlank(message = "Last Name is required")
    @Size(min = 2, max = 100, message = "Last Name should have between 2 and 100 characters")
    private String lastName;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @Email(regexp = "^[a-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid email format")
    @Size(min = 7, max = 74, message = "Email should have between 7 and 74 characters")
    private String email;

    @NotNull(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@$!%*#?&])(?=\\S+$).{8,}$", message = "Password should contain minimum eight characters, at least one letter, one number and one special character.")
    private String password;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    private String faculty;
    private String phoneNumber;
    private String specialization;
    private String university;
    private String yearOfStudy;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
