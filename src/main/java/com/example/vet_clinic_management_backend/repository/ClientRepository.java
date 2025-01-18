package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.entity.Client;

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
public class ClientRepository {
    @SuppressWarnings("null")
    public ApiFuture<List<Client>> findAllClients() {
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("clients").get();

        return ApiFutures.transform(future, querySnapshot -> {
            List<Client> clients = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                Client client = documentSnapshot.toObject(Client.class);
                client.setDocumentId(documentSnapshot.getId());
                clients.add(client);
            }

            return clients;
        });
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
