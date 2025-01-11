package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.Client;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
    public ApiFuture<QuerySnapshot> findAllClients() {
        return FirestoreClient.getFirestore().collection("clients").get();
    }

    public ApiFuture<DocumentSnapshot> findClientById(String documentId) {
        return FirestoreClient.getFirestore().collection("clients").document(documentId).get();
    }

    public ApiFuture<DocumentReference> saveClient(Client client) {
        return FirestoreClient.getFirestore().collection("clients").add(client);
    }

    public ApiFuture<WriteResult> updateClient(String documentId, Client client) {
        return FirestoreClient.getFirestore().collection("clients").document(documentId).set(client);
    }

    public ApiFuture<WriteResult> deleteClient(String documentId) {
        return FirestoreClient.getFirestore().collection("clients").document(documentId).delete();
    }
}
