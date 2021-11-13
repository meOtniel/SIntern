package com.sintern.service;

import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;

import java.util.List;

public interface DomainService {

    List<Domain> getDomains();

    List<Domain> getDomainsByDomainType(DomainType domainType);
}
