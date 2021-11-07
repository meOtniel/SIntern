package com.sintern.api;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPositionDTO;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open-positions")
public class OpenInternPositionController {
    private OpenInternPositionService openInternPositionService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionService openInternPositionService) {
        this.openInternPositionService = openInternPositionService;
    }

    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByAddress(@PathVariable String address){
        return openInternPositionService.findOpenInternPositionDTOByCompanyAddress(address);
    }

    @RequestMapping(value = "/domain/{domainType}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByDomain(@PathVariable DomainType domainType){
        return openInternPositionService.findOpenInternPositionDTOByCompanyDomain(domainType);
    }
}
