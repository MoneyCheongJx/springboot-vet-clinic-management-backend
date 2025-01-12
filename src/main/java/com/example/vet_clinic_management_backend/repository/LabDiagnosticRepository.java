package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.Client;
import com.example.vet_clinic_management_backend.dto.LabDiagnostic;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class LabDiagnosticRepository {
    
    @SuppressWarnings("null")
    public ApiFuture<List<LabDiagnostic>> findAllLabDiagnostics() {
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("lab_diagnostics").get();

        return ApiFutures.transform(future, querySnapshot -> {
            List<LabDiagnostic> labDiagnostics = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                LabDiagnostic labDiagnostic = documentSnapshot.toObject(LabDiagnostic.class);
                labDiagnostic.setDocumentId(documentSnapshot.getId());
                labDiagnostics.add(labDiagnostic);
            }

            return labDiagnostics;
        });
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
