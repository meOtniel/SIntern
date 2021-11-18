package com.sintern.api;

import com.sintern.domain.dto.DomainDTO;
import com.sintern.domain.entity.DomainImage;
import com.sintern.service.DomainImageService;
import com.sintern.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/domains")
public class DomainController {

    private final DomainService domainService;
    private final DomainImageService domainImageService;

    @Autowired
    public DomainController(DomainService domainService, DomainImageService domainImageService) {
        this.domainService = domainService;
        this.domainImageService = domainImageService;
    }

    @GetMapping
    public List<DomainDTO> getDomains() {
        List<DomainDTO> domainDTOList = domainService.getDomainsDTO();
        for (DomainDTO domainDTO : domainDTOList) {
            Optional<DomainImage> domainImageOptional = domainImageService.getDomainImageByDomainId(domainDTO.getId());
            if (domainImageOptional.isPresent()) {
                byte[] imageContent = domainImageOptional.get().getData();
                String encodedStringDomainImage = Base64.getEncoder().encodeToString(imageContent);
                domainDTO.setDomainImage(encodedStringDomainImage);
            }
        }
        return domainDTOList;
    }

    @PostMapping("/upload-image")
    @ResponseStatus(HttpStatus.OK)
    public void uploadImage(@RequestParam("id") UUID domainId, @RequestParam("image") MultipartFile image) {
        domainImageService.save(image, domainId);
    }

}
