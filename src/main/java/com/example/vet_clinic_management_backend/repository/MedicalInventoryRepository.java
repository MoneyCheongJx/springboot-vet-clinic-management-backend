package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.MedicalInventory;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalInventoryRepository {
    
    public ApiFuture<QuerySnapshot> findAllMedicalInventories() {
        return FirestoreClient.getFirestore().collection("medical_inventories").get();
    }

    public ApiFuture<DocumentSnapshot> findMedicalInventoryById(String documentId) {
        return FirestoreClient.getFirestore().collection("medical_inventories").document(documentId).get();
    }

    public ApiFuture<DocumentReference> saveMedicalInventory(MedicalInventory medicalInventory) {
        return FirestoreClient.getFirestore().collection("medical_inventories").add(medicalInventory);
    }

    public ApiFuture<WriteResult> updateMedicalInventory(String documentId, MedicalInventory medicalInventory) {
        return FirestoreClient.getFirestore().collection("medical_inventories").document(documentId).set(medicalInventory);
    }

    public ApiFuture<WriteResult> deleteMedicalInventory(String documentId) {
        return FirestoreClient.getFirestore().collection("medical_inventories").document(documentId).delete();
    }
}
