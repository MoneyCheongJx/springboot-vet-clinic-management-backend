package com.example.vet_clinic_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet_clinic_management_backend.entity.LabDiagnostic;
import com.example.vet_clinic_management_backend.service.LabDiagnosticService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Lab Dianostic Module", description = "")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/lab")
public class LabDiagnosticController {
    private final LabDiagnosticService labDiagnosticService;

    @Autowired
    public LabDiagnosticController(LabDiagnosticService labDiagnosticService) {
        this.labDiagnosticService = labDiagnosticService;
    }

    @GetMapping
    public String getLabDiagnosticsList() {
        return labDiagnosticService.getLabDiagnosticList();
    }

    @PostMapping("/create")
    public String createLabDiagnostic(@RequestBody LabDiagnostic labDiagnostic) {
        return labDiagnosticService.createLabDiagnostic(labDiagnostic);
    }

    @PutMapping("/update")
    public String updateLabDiagnostic(
            @RequestParam("documentId") String documentId,
            @RequestBody LabDiagnostic labDiagnostic) {
        return labDiagnosticService.updateLabDiagnostic(documentId, labDiagnostic);
    }

    @DeleteMapping("/delete")
    public String deleteLabDiagnostic(@RequestParam String documentId) {
        return labDiagnosticService.deleteLabDiagnostic(documentId);
    }
}
