package com.sintern.domain.dto;

import com.sintern.domain.enums.DomainType;

import java.util.UUID;

public class DomainDTO {

    private UUID id;
    private String description;
    private DomainType domainType;
    private String domainImage;

    public DomainDTO(UUID id, String description, DomainType domainType) {
        this.id = id;
        this.description = description;
        this.domainType = domainType;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DomainType getDomainType() {
        return domainType;
    }

    public void setDomainType(DomainType domainType) {
        this.domainType = domainType;
    }

    public void setDomainImage(String domainImage) {
        this.domainImage = domainImage;
    }

    @Override
    public String toString() {
        return "DomainDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", domainType=" + domainType +
                ", domainImage='" + domainImage + '\'' +
                '}';
    }
}
