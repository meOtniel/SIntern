package com.sintern.api;

import com.sintern.domain.dto.OpenInternPositionDTO;
import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.CompanyLogo;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import com.sintern.service.CompanyService;
import com.sintern.service.LogoService;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/open-positions")
public class OpenInternPositionController {

    private final OpenInternPositionService openInternPositionService;
    private final LogoService logoService;
    private final CompanyService companyService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionService openInternPositionService, LogoService logoService, CompanyService companyService) {
        this.openInternPositionService = openInternPositionService;
        this.logoService = logoService;
        this.companyService = companyService;
    }

    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByAddress(@PathVariable String address) {
        return openInternPositionService.findOpenInternPositionDTOByCompanyAddress(address);
    }

    @RequestMapping(value = "/domain/{domainType}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByDomain(@PathVariable String domainType) {
        List<OpenInternPositionDTO> dtoList = openInternPositionService.findOpenInternPositionDTOByCompanyDomain(DomainType.valueOf(domainType));

        //Set CompanyLogo for the OpenInternPositionDTO - Base64
        for (OpenInternPositionDTO openInternPositionDTO : dtoList) {
            Company company = openInternPositionService.getOpenInternPositionById(openInternPositionDTO.getId()).getCompany();
            Optional<CompanyLogo> companyLogoOptional = logoService.getLogoByCompanyId(company.getId());
            if (companyLogoOptional.isPresent()) {
                byte[] imageContent = companyLogoOptional.get().getData();
                String encodedStringCompanyLogo = Base64.getEncoder().encodeToString(imageContent);
                openInternPositionDTO.setCompanyLogo(encodedStringCompanyLogo);
            }
        }
        return dtoList;
    }

    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    public List<Domain> getDomains() {
        return openInternPositionService.getDomains();
    }

    @GetMapping("/{openPositionId}/company-logo")
    public ResponseEntity<byte[]> getLogo(@PathVariable UUID openPositionId) {
        Company company = openInternPositionService.getOpenInternPositionById(openPositionId).getCompany();
        Optional<CompanyLogo> companyLogoOptional = logoService.getLogoByCompanyId(company.getId());
        if (companyLogoOptional.isEmpty()) {
            return ResponseEntity.notFound()
                    .build();
        }
        CompanyLogo companyLogo = companyLogoOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "image; filename=\"" + companyLogo.getName() + "\"")
                .contentType(MediaType.valueOf(companyLogo.getContentType()))
                .body(companyLogo.getData());
    }

    @RequestMapping(value = "/company/{companyID}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> getInternPositionsByCompany(@PathVariable UUID companyID) {
        Company company = companyService.findByID(companyID);
        return openInternPositionService.findOpenInternPositionDTOByCompany(company);

    }
}
