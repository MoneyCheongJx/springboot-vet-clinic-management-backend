package com.example.vet_clinic_management_backend.service;

import com.example.vet_clinic_management_backend.entity.PetPatient;

public interface PetPatientService {
    String getPetPatientsList();
    String createPetPatient(PetPatient petPatient);
    String updatePetPatient(String documentId, PetPatient petPatient);
    String deletePetPatient(String documentId);
}
