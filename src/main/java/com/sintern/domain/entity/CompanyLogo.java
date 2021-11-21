package com.sintern.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "logo_of_company")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyLogo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    String name;

    String contentType;

    Long size;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    byte[] data;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    Company company;
}
