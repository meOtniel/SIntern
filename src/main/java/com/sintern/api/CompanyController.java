package com.sintern.api;

import com.sintern.api.request.CompanyRegisterRequest;
import com.sintern.service.CompanyService;
import com.sintern.service.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.UUID;

import static com.sintern.api.request.transformer.CompanyRegisterTransformer.transform;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final LogoService logoService;

    @Autowired
    public CompanyController(CompanyService companyService, LogoService logoService) {
        this.companyService = companyService;
        this.logoService = logoService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void processRegister(@Valid @RequestBody CompanyRegisterRequest companyRegisterRequest) {
        companyService.addCompany(transform(companyRegisterRequest));
    }

    @PostMapping("/upload-logo")
    @ResponseStatus(HttpStatus.OK)
    public void uploadLogo(@RequestParam("id") UUID companyId, @RequestParam("image") MultipartFile image) {
        logoService.save(image, companyId);
    }
}
