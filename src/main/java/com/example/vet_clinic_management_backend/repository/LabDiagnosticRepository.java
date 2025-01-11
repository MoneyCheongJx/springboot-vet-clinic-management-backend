package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.LabDiagnostic;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class LabDiagnosticRepository {
    
    public ApiFuture<QuerySnapshot> findAllLabDiagnostics() {
        return FirestoreClient.getFirestore().collection("lab_diagnostics").get();
    }

    public ApiFuture<DocumentSnapshot> findLabDiagnosticById(String documentId) {
        return FirestoreClient.getFirestore().collection("lab_diagnostics").document(documentId).get();
    }

    public ApiFuture<DocumentReference> saveLabDiagnostic(LabDiagnostic labDiagnostic) {
        return FirestoreClient.getFirestore().collection("lab_diagnostics").add(labDiagnostic);
    }

    public ApiFuture<WriteResult> updateLabDiagnostic(String documentId, LabDiagnostic labDiagnostic) {
        return FirestoreClient.getFirestore().collection("lab_diagnostics").document(documentId).set(labDiagnostic);
    }

    public ApiFuture<WriteResult> deleteLabDiagnostic(String documentId) {
        return FirestoreClient.getFirestore().collection("lab_diagnostics").document(documentId).delete();
    }
}
