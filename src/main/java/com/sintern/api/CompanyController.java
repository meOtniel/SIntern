package com.sintern.api;

import com.sintern.api.request.CompanyRegisterRequest;
import com.sintern.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.sintern.api.request.transformer.CompanyRegisterTransformer.transform;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void processRegister(@Valid @RequestBody CompanyRegisterRequest companyRegisterRequest) {
        companyService.addCompany(transform(companyRegisterRequest));
    }
}
