package com.sintern.service;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPosition;
import com.sintern.repository.OpenInternPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenInternPositionService {
    private OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public OpenInternPositionService(OpenInternPositionRepository openInternPositionRepository) {
        this.openInternPositionRepository = openInternPositionRepository;
    }

    public List<OpenInternPosition> findOpenInternPositionByCompany_Address(String address){
        return openInternPositionRepository.findOpenInternPositionByCompany_Address(address);
    }
    public List<OpenInternPosition> findOpenInternPositionByCompany_Domain(DomainType companyDomain){
        return openInternPositionRepository.findOpenInternPositionByCompany_Domain(companyDomain);
    }
}
