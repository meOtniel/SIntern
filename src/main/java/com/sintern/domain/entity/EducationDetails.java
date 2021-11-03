package com.sintern.domain.entity;


import com.sintern.domain.enums.SpecializationType;
import com.sintern.domain.enums.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationDetails {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    UniversityType university;
    String faculty;
    SpecializationType specialization;
    String yearOfStudy;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
