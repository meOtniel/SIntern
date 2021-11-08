package com.sintern.api;

import com.sintern.domain.Company;
import com.sintern.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void processRegister(@RequestBody Company company) {
        companyService.addCompany(company);
    }
}
