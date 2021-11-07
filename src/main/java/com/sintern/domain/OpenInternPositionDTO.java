package com.sintern.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailablePositions() {
        return availablePositions;
    }

    public void setAvailablePositions(int availablePositions) {
        this.availablePositions = availablePositions;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public DomainType getCompanyDomain() {
        return companyDomain;
    }

    public void setCompanyDomain(DomainType companyDomain) {
        this.companyDomain = companyDomain;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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
