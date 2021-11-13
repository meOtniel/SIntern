package com.sintern.api;

import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import com.sintern.domain.dto.OpenInternPositionDTO;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/open-positions")
public class OpenInternPositionController {
    private final OpenInternPositionService openInternPositionService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionService openInternPositionService) {
        this.openInternPositionService = openInternPositionService;
    }

    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByAddress(@PathVariable String address){
        return openInternPositionService.findOpenInternPositionDTOByCompanyAddress(address);
    }

    @RequestMapping(value = "/domain/{domainType}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByDomain(@PathVariable String domainType){
        return openInternPositionService.findOpenInternPositionDTOByCompanyDomain(DomainType.valueOf(domainType));
    }

    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    public List<Domain> getDomains(){
        return openInternPositionService.getDomains();
    }
}
