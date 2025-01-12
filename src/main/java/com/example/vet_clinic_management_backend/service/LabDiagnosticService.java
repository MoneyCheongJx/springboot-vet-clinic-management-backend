package com.example.vet_clinic_management_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.dto.Client;
import com.example.vet_clinic_management_backend.dto.LabDiagnostic;
import com.example.vet_clinic_management_backend.repository.LabDiagnosticRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LabDiagnosticService {

    @Autowired
    private LabDiagnosticRepository labDiagnosticRepository;

    public String getLabDiagnosticList() {
      try {
            ApiFuture<List<LabDiagnostic>> labDiagnosticFuture = labDiagnosticRepository.findAllLabDiagnostics();
            List<LabDiagnostic> labDiagnosticList = labDiagnosticFuture.get(); 
    
            if (labDiagnosticList.isEmpty()) {
                System.out.println("No lab diagnostics found in database.");
            } else {
                System.out.println("Lab diagnostics retrieved from database: " + labDiagnosticList);
            }
    
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(labDiagnosticList);
    
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving lab diagnostics: " + e.getMessage();
        }
    }

    public String create(LabDiagnostic labDiagnostic) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = labDiagnosticRepository.saveLabDiagnostic(labDiagnostic);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Lab diagnotic saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving lab diagnostic: " + e.getMessage();
        }
    }

    public String update(String documentId, LabDiagnostic labDiagnostic) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = labDiagnosticRepository.findLabDiagnosticById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = labDiagnosticRepository.updateLabDiagnostic(documentId, labDiagnostic);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Lab diagnostic updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No lab diagnotic found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating lab diagnostic: " + e.getMessage();
        }
    }

    public String delete(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = labDiagnosticRepository.findLabDiagnosticById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = labDiagnosticRepository.deleteLabDiagnostic(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Lab diagnostic deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No lab diagnostic found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting lab diagnostic: " + e.getMessage();
        }
    }
}
