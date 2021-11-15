package com.sintern.api;

import com.sintern.domain.dto.OpenInternPositionDTO;
import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.CompanyLogo;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.enums.DomainType;
import com.sintern.service.LogoService;
import com.sintern.service.OpenInternPositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/open-positions")
public class OpenInternPositionController {
    private final OpenInternPositionServiceImpl openInternPositionService;
    private final LogoService logoService;

    @Autowired
    public OpenInternPositionController(OpenInternPositionServiceImpl openInternPositionService, LogoService logoService) {
        this.openInternPositionService = openInternPositionService;
        this.logoService = logoService;
    }

    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByAddress(@PathVariable String address) {
        return openInternPositionService.findOpenInternPositionDTOByCompanyAddress(address);
    }

    @RequestMapping(value = "/domain/{domainType}", method = RequestMethod.GET)
    public List<OpenInternPositionDTO> filterByDomain(@PathVariable String domainType) {
        return openInternPositionService.findOpenInternPositionDTOByCompanyDomain(DomainType.valueOf(domainType));
    }

    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    public List<Domain> getDomains() {
        return openInternPositionService.getDomains();
    }

    @GetMapping("{openPositionId}/company-logo/")
    public ResponseEntity<byte[]> getLogo(@PathVariable UUID openPositionId) {

        Optional<CompanyLogo> companyLogoOptional = logoService.getLogoByCompanyId(openInternPositionService.getOpenInternPositionById(openPositionId).getCompany().getId());

        if (!companyLogoOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        CompanyLogo companyLogo = companyLogoOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "image; filename=\"" + companyLogo.getName() + "\"")
                .contentType(MediaType.valueOf(companyLogo.getContentType()))
                .body(companyLogo.getData());
    }

}
