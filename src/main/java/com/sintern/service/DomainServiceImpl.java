package com.sintern.service;

import com.sintern.domain.dto.DomainDTO;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import com.sintern.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    @Autowired
    public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Override
    public List<Domain> getDomains() {
        return domainRepository.findAll();
    }

    @Override
    public List<Domain> getDomainsByDomainType(DomainType domainType) {
        return domainRepository.findByDomainType(domainType);
    }

    @Override
    public List<DomainDTO> getDomainsDTO() {
        List<DomainDTO> domainDTOList = new ArrayList<>();
        for (Domain domain : domainRepository.findAll()) {
            DomainDTO domainDTO = new DomainDTO(domain.getId(), domain.getDescription(), domain.getDomainType());
            domainDTOList.add(domainDTO);
        }
        return domainDTOList;
    }
}
