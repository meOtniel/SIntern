package com.sintern.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Domain {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    String description;

    DomainType domainType;

    @JsonIgnore
    @OneToOne(mappedBy = "domain")
    Company company;

    @Override
    public String toString() {
        return "Domain{" +
                "description='" + description + '\'' +
                ", domainType=" + domainType +
                '}';
    }
}
