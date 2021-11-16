package com.sintern.service;

import com.sintern.domain.dto.OpenInternPositionDTO;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.enums.DomainType;

import java.util.List;
import java.util.UUID;

public interface OpenInternPositionService {
    OpenInternPosition getOpenInternPositionById(UUID openInetrnPositionId);

    List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyAddress(String address);

    List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyDomain(DomainType domainType);

    List<Domain> getDomains();
}
