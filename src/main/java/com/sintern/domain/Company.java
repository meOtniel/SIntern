package com.sintern.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company extends User {

    String name;
    String address;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    Domain domain;

    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    List<OpenInternPosition> openPositions;
}
