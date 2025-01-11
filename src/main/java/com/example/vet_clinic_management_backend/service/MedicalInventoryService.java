package com.example.vet_clinic_management_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.dto.MedicalInventory;
import com.example.vet_clinic_management_backend.repository.MedicalInventoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class MedicalInventoryService {

    @Autowired
    private MedicalInventoryRepository medicalInventoryRepository;

    public String getMedicalInventoryList() {
        try {
            ApiFuture<QuerySnapshot> querySnapshotApiFuture = medicalInventoryRepository.findAllMedicalInventories();
            List<QueryDocumentSnapshot> documents = querySnapshotApiFuture.get().getDocuments();

            List<MedicalInventory> medicalInventoryList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                MedicalInventory medicalInventory = document.toObject(MedicalInventory.class);
                medicalInventoryList.add(medicalInventory);
            }

            if (medicalInventoryList.isEmpty()) {
                System.out.println("No medical inventories found in database.");
            } else {
                System.out.println("Medical inventories retrieved from database: " + medicalInventoryList);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(medicalInventoryList);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving medical inventories: " + e.getMessage();
        }
    }

    public String create(MedicalInventory medicalInventory) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = medicalInventoryRepository.saveMedicalInventory(medicalInventory);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Medical inventory saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving medical inventory: " + e.getMessage();
        }
    }

    public String update(String documentId, MedicalInventory medicalInventory) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = medicalInventoryRepository.findMedicalInventoryById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = medicalInventoryRepository.updateMedicalInventory(documentId, medicalInventory);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Medical inventory updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No medical inventory found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating medical inventory: " + e.getMessage();
        }
    }

    public String delete(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = medicalInventoryRepository.findMedicalInventoryById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = medicalInventoryRepository.deleteMedicalInventory(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Medical inventory deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No medical inventory found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting medical inventory: " + e.getMessage();
        }
    }
}
