package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.PetPatient;

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
public class PetPatientRepository {
    
    @SuppressWarnings("null")
    public ApiFuture<List<PetPatient>> findAllPetPatients() {
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("pet_patients").get();

        return ApiFutures.transform(future, querySnapshot -> {
            List<PetPatient> petPatients = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                PetPatient petPatient = documentSnapshot.toObject(PetPatient.class);
                petPatient.setDocumentId(documentSnapshot.getId());
                petPatients.add(petPatient);
            }

            return petPatients;
        });
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
