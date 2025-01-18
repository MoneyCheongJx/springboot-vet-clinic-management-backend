package com.example.vet_clinic_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.entity.PetPatient;
import com.example.vet_clinic_management_backend.repository.PetPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class PetPatientService {

    @Autowired
    private PetPatientRepository petPatientRepository;

    public String getPetPatientsList() {
        try {
            ApiFuture<List<PetPatient>> petPatientFuture = petPatientRepository.findAllPetPatients();
            List<PetPatient> petPatientsList = petPatientFuture.get(); 
    
            if (petPatientsList.isEmpty()) {
                System.out.println("No pet patients found in database.");
            } else {
                System.out.println("Pet patients retrieved from database: " + petPatientsList);
            }
    
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(petPatientsList);
    
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving pet patients: " + e.getMessage();
        }
    }

    public String create(PetPatient petPatient) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = petPatientRepository.savePetPatient(petPatient);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Pet patient saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving pet patient: " + e.getMessage();
        }
    }

    public String update(String documentId, PetPatient petPatient) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = petPatientRepository.findPetPatientById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = petPatientRepository.updatePetPatient(documentId, petPatient);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Pet patient updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No pet patient found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating pet patient: " + e.getMessage();
        }
    }

    public String delete(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = petPatientRepository.findPetPatientById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = petPatientRepository.deletePetPatient(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Pet patient deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No pet patient found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting pet patient: " + e.getMessage();
        }
    }
}
