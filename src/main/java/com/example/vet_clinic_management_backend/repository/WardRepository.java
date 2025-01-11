package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.Ward;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class WardRepository {
    
    public ApiFuture<QuerySnapshot> findAllWards() {
        return FirestoreClient.getFirestore().collection("wards").get();
    }

    public ApiFuture<DocumentSnapshot> findWardById(String documentId) {
        return FirestoreClient.getFirestore().collection("wards").document(documentId).get();
    }

    public ApiFuture<DocumentReference> saveWard(Ward ward) {
        return FirestoreClient.getFirestore().collection("wards").add(ward);
    }

    public ApiFuture<WriteResult> updateWard(String documentId, Ward ward) {
        return FirestoreClient.getFirestore().collection("wards").document(documentId).set(ward);
    }

    public ApiFuture<WriteResult> deleteWard(String documentId) {
        return FirestoreClient.getFirestore().collection("wards").document(documentId).delete();
    }
}
