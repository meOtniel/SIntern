package com.sintern.api.response;

import com.sintern.domain.enums.DomainType;

public class GetCompanyDomainResponse {

    private String description;
    private DomainType domainType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DomainType getDomainType() {
        return domainType;
    }

    public void setDomainType(DomainType domainType) {
        this.domainType = domainType;
    }
}
