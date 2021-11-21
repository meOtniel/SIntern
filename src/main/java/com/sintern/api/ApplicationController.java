package com.sintern.api;

import com.sintern.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void addApplication(@RequestParam("studentID") UUID studID,
                               @RequestParam("openInternPositionID") UUID openInternPosID,
                               @RequestParam("description") String descr){
        applicationService.addApplication(studID, openInternPosID, descr);
    }
}