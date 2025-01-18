package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.entity.MedicalInventory;

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
public class MedicalInventoryRepository {

    @SuppressWarnings("null")
    public ApiFuture<List<MedicalInventory>> findAllMedicalInventories() {
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("medical_inventories").get();

        return ApiFutures.transform(future, querySnapshot -> {
            List<MedicalInventory> medicalInventories = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                MedicalInventory medicalInventory = documentSnapshot.toObject(MedicalInventory.class);
                medicalInventory.setDocumentId(documentSnapshot.getId());
                medicalInventories.add(medicalInventory);
            }

            return medicalInventories;
        });
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
