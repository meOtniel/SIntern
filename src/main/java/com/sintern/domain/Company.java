package com.sintern.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    Domain domain;

    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    List<OpenInternPosition> openPositions;
}
