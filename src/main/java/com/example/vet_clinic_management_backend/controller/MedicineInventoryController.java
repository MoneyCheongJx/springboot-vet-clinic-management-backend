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

import com.example.vet_clinic_management_backend.dto.MedicalInventory;
import com.example.vet_clinic_management_backend.service.MedicalInventoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Medical Inventory Module", description = "")
@RestController
@RequestMapping("/medical")
public class MedicineInventoryController {
    private final MedicalInventoryService medicalInventoryService;

    @Autowired
    public MedicineInventoryController(MedicalInventoryService medicalInventoryService) {
        this.medicalInventoryService = medicalInventoryService;
    }

    @GetMapping
    public String getMedicalInventoryList() {
        return medicalInventoryService.getMedicalInventoryList();
    }

    @PostMapping("/create")
    public String createLabDiagnostic(@RequestBody MedicalInventory medicalInventory) {
        return medicalInventoryService.create(medicalInventory);
    }

    @PutMapping("/update")
    public String updateLabDiagnostic(
            @RequestParam("documentId") String documentId,
            @RequestBody MedicalInventory medicalInventory) {
        return medicalInventoryService.update(documentId, medicalInventory);
    }

    @DeleteMapping("/delete")
    public String deleteLabDiagnostic(@RequestParam String documentId) {
        return medicalInventoryService.delete(documentId);
    }
}
