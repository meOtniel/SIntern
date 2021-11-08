package com.sintern.service;

import com.sintern.domain.Domain;
import com.sintern.domain.DomainType;

import java.util.List;

public interface DomainService {

    List<Domain> getDomains();

    List<Domain> getDomainsByDomainType(DomainType domainType);
}
