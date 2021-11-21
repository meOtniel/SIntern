package com.sintern.api.response;

public class GetCompanyResponse {

    private String name;
    private String address;
    private GetCompanyDomainResponse domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GetCompanyDomainResponse getDomain() {
        return domain;
    }

    public void setDomain(GetCompanyDomainResponse domain) {
        this.domain = domain;
    }
}
