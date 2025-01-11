package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.PetPatient;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class PetPatientRepository {
    
    public ApiFuture<QuerySnapshot> findAllPetPatients() {
        return FirestoreClient.getFirestore().collection("pet_patients").get();
    }

    public ApiFuture<DocumentSnapshot> findPetPatientById(String documentId) {
        return FirestoreClient.getFirestore().collection("pet_patients").document(documentId).get();
    }

    public ApiFuture<DocumentReference> savePetPatient(PetPatient petPatient) {
        return FirestoreClient.getFirestore().collection("pet_patients").add(petPatient);
    }

    public ApiFuture<WriteResult> updatePetPatient(String documentId, PetPatient petPatient) {
        return FirestoreClient.getFirestore().collection("pet_patients").document(documentId).set(petPatient);
    }

    public ApiFuture<WriteResult> deletePetPatient(String documentId) {
        return FirestoreClient.getFirestore().collection("pet_patients").document(documentId).delete();
    }
}
