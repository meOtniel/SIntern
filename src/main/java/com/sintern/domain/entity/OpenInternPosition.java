package com.sintern.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sintern.domain.entity.Company;
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
public class OpenInternPosition {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    String name;
    String department;
    String description;
    int availablePositions;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    Company company;
}
