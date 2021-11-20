package com.sintern.domain.dto;

import com.sintern.domain.enums.DomainType;

import java.util.UUID;

public class OpenInternPositionDTO {

    private UUID id;
    private String name;
    private String department;
    private String description;
    private int availablePositions;

    private String companyName;
    private DomainType companyDomain;
    private String companyAddress;
    private String companyLogo;

    public OpenInternPositionDTO(UUID id, String name, String department, String description, int availablePositions, String companyName, DomainType companyDomain, String companyAddress) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.description = description;
        this.availablePositions = availablePositions;
        this.companyName = companyName;
        this.companyDomain = companyDomain;
        this.companyAddress = companyAddress;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @Override
    public String toString() {
        return "OpenInternPositionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", description='" + description + '\'' +
                ", availablePositions=" + availablePositions +
                ", companyName='" + companyName + '\'' +
                ", companyDomain=" + companyDomain +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
