package com.sintern.api.request.transformer;

import com.sintern.api.request.CompanyRegisterRequest;
import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import com.sintern.exception.NonExistentDomainException;

public class CompanyRegisterTransformer {

    public static Company transform(CompanyRegisterRequest companyRegisterRequest) {
        Company company = new Company();
        company.setEmail(companyRegisterRequest.getEmail());
        company.setPassword(companyRegisterRequest.getPassword());
        company.setName(companyRegisterRequest.getName());
        company.setAddress(companyRegisterRequest.getAddress());

        Domain domain = new Domain();
        try {
            domain.setDomainType(DomainType.valueOf(companyRegisterRequest.getDomainType()));
        } catch (IllegalArgumentException exception) {
            throw new NonExistentDomainException("There are no domains with this domain type!");
        }
        company.setDomain(domain);

        return company;
    }
}
