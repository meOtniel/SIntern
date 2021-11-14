package com.sintern.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "file")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    String name;

    String contentType;

    Long size;

    @Lob
    byte[] data;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;

}
