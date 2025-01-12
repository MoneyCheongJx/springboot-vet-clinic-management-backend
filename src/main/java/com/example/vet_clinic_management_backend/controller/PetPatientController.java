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

import com.example.vet_clinic_management_backend.dto.PetPatient;
import com.example.vet_clinic_management_backend.service.PetPatientService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pet Patient Module", description = "")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pet")
public class PetPatientController {
    private final PetPatientService petPatientService;

    @Autowired
    public PetPatientController(PetPatientService petPatientService) {
        this.petPatientService = petPatientService;
    }

    @GetMapping
    public String getPetPatientList() {
        return petPatientService.getPetPatientsList();
    }

    @PostMapping("/create")
    public String createPetPatient(@RequestBody PetPatient petPatient) {
        return petPatientService.create(petPatient);
    }

    @PutMapping("/update")
    public String updatePetPatient(
            @RequestParam("documentId") String documentId,
            @RequestBody PetPatient petPatient) {
        return petPatientService.update(documentId, petPatient);
    }

    @DeleteMapping("/delete")
    public String deletePetPatient(@RequestParam String documentId) {
        return petPatientService.delete(documentId);
    }
}
