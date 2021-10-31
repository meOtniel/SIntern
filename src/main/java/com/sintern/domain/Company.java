package com.sintern.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company extends User {

    String name;
    DomainType domain;
    String address;

    @OneToMany(mappedBy = "company")
    List<OpenInternPosition> openPositions;
}
