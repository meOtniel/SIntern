package com.sintern.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@MappedSuperclass
@Table(name = "sintern_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @Email(regexp = "^[a-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid email format")
    @Column(name = "email", unique = true)
    @Size(min = 7, max = 74, message = "Email should have between 7 and 74 characters")
    String email;

    @JsonIgnore
    @NotNull(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@$!%*#?&])(?=\\S+$).{8,}$", message = "Password should contain minimum eight characters, at least one letter, one number and one special character.")
    String password;
}
