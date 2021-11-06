package com.sintern.api;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPosition;
import com.sintern.domain.OpenInternPositionDTO;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open-positions")
public class OpenInternPositionController {
    public OpenInternPositionService openInternPositionService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionService openInternPositionService) {
        this.openInternPositionService = openInternPositionService;
    }
    
    @RequestMapping(value = "/domain", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByDomain(DomainType domainType){
        return openInternPositionService.findOpenInternPositionDTOByCompany_Domain(domainType);
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByAddress(String address){
        return openInternPositionService.findOpenInternPositionDTOByCompany_Address(address);
    }
}
