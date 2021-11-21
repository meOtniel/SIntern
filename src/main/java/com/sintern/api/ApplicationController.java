package com.sintern.api;

import com.sintern.api.request.AddApplicationRequest;
import com.sintern.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addApplication(@RequestBody AddApplicationRequest addApplicationRequest) {
        applicationService.addApplication(addApplicationRequest.getStudentID(),
                addApplicationRequest.getOpenInternPositionID(), addApplicationRequest.getDescription());
    }
}