package com.example.vet_clinic_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet_clinic_management_backend.dto.Ward;
import com.example.vet_clinic_management_backend.service.WardService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Ward Module", description = "")
@RestController
@RequestMapping("/ward")
public class WardController {
    private final WardService wardService;

    @Autowired
    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping
    public String getWardList() {
        return wardService.getWardList();
    }

    @PostMapping("/create")
    public String createStaff(@RequestBody Ward ward) {
        return wardService.create(ward);
    }

    @PutMapping("/update")
    public String updateWard(
            @RequestParam("documentId") String documentId,
            @RequestBody Ward ward) {
        return wardService.update(documentId, ward);
    }

    @DeleteMapping("/delete")
    public String deleteWard(@RequestParam String documentId) {
        return wardService.delete(documentId);
    }
}
