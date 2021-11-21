package com.sintern.api.response.transformer;

import com.sintern.api.response.GetCompanyResponse;
import com.sintern.domain.entity.Company;

public class GetCompanyTransformer {

    public static GetCompanyResponse transform(Company company) {
        GetCompanyResponse getCompanyResponse = new GetCompanyResponse();
        getCompanyResponse.setName(company.getName());
        getCompanyResponse.setAddress(company.getAddress());
        getCompanyResponse.setDomain(GetCompanyDomainTransformer.transform(company.getDomain()));
        return getCompanyResponse;
    }
}