package com.sintern.api;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPosition;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API/OpenInternPosition")
public class OpenInternPositionController {
    public OpenInternPositionService openInternPositionService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionService openInternPositionService) {
        this.openInternPositionService = openInternPositionService;
    }

    @RequestMapping(value = "/FilterByDomain", method = RequestMethod.GET)
    public List<OpenInternPosition> filterByDomain(DomainType domainType){
        return openInternPositionService.findOpenInternPositionByCompany_Domain(domainType);
    }

    @RequestMapping(value = "/FilterByAddress", method = RequestMethod.GET)
    public List<OpenInternPosition> filterByAddress(String address){
        return openInternPositionService.findOpenInternPositionByCompany_Address(address);
    }
}
