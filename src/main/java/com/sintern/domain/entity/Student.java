package com.sintern.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends User implements UserDetails {
    @NotNull(message = "First Name is required")
    @NotBlank(message = "First Name is required")
    @Size(min = 2, max = 100, message = "First Name should have between 2 and 100 characters")
    String firstName;

    @NotNull(message = "Last Name is required")
    @NotBlank(message = "Last Name is required")
    @Size(min = 2, max = 100, message = "Last Name should have between 2 and 100 characters")
    String lastName;

    @NotNull(message = "Date of birth is required")
    LocalDate dateOfBirth;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^(\\d{3}[- ]?){2}\\d{4}$", message = "Invalid phone number")
    String phoneNumber;

    @OneToOne(mappedBy = "student")
    EducationDetails educationDetails;
  
    @OneToOne(mappedBy = "student")
    FileEntity cv;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", educationDetails=" + educationDetails +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}