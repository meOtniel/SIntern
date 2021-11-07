package com.sintern.api;

import com.sintern.domain.Domain;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DomainController {

    public OpenInternPositionService openInternPositionService;

    @Autowired
    public DomainController(OpenInternPositionService openInternPositionService) {
        this.openInternPositionService = openInternPositionService;
    }

    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    public List<Domain> getDomains(){
        return openInternPositionService.getDomains();
    }
}
