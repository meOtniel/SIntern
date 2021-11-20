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
@Table(name = "image_of_domain")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DomainImage {

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
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    Domain domain;
}
