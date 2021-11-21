package com.sintern.api.response.transformer;

import com.sintern.api.response.GetCompanyDomainResponse;
import com.sintern.domain.entity.Domain;

public class GetCompanyDomainTransformer {

    public static GetCompanyDomainResponse transform(Domain domain) {
        GetCompanyDomainResponse getCompanyDomainResponse = new GetCompanyDomainResponse();
        getCompanyDomainResponse.setDescription(domain.getDescription());
        getCompanyDomainResponse.setDomainType(domain.getDomainType());
        return getCompanyDomainResponse;
    }
}
