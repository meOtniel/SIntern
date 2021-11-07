package com.sintern.service;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPosition;
import com.sintern.domain.OpenInternPositionDTO;
import com.sintern.repository.OpenInternPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenInternPositionService {
    private OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public OpenInternPositionService(OpenInternPositionRepository openInternPositionRepository) {
        this.openInternPositionRepository = openInternPositionRepository;
    }

    public List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyAddress(String address){
        List<OpenInternPositionDTO> openInternPositionDTOList = new ArrayList<>();

        for (OpenInternPosition openInterPosition: openInternPositionRepository.findOpenInternPositionByCompany_Address(address)) {
            OpenInternPositionDTO openInternPositionDTO = new OpenInternPositionDTO(openInterPosition.getId(), openInterPosition.getName(),
                    openInterPosition.getDepartment(), openInterPosition.getDescription(), openInterPosition.getAvailablePositions(),
                    openInterPosition.getCompany().getName(), openInterPosition.getCompany().getDomain(), openInterPosition.getCompany().getAddress());
            openInternPositionDTOList.add(openInternPositionDTO);
        }
        return  openInternPositionDTOList;
    }

    public List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyDomain(DomainType domainType){
        List<OpenInternPositionDTO> openInternPositionDTOList = new ArrayList<>();

        for (OpenInternPosition openInterPosition: openInternPositionRepository.findOpenInternPositionByCompany_Domain(domainType)) {
            OpenInternPositionDTO openInternPositionDTO = new OpenInternPositionDTO(openInterPosition.getId(), openInterPosition.getName(),
                    openInterPosition.getDepartment(), openInterPosition.getDescription(), openInterPosition.getAvailablePositions(),
                    openInterPosition.getCompany().getName(), openInterPosition.getCompany().getDomain(), openInterPosition.getCompany().getAddress());
            openInternPositionDTOList.add(openInternPositionDTO);
        }
        return  openInternPositionDTOList;
    }
}
