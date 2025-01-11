package com.example.vet_clinic_management_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.dto.Client;
import com.example.vet_clinic_management_backend.repository.ClientRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public String getClientList() {
        try {
            ApiFuture<QuerySnapshot> querySnapshotApiFuture = clientRepository.findAllClients();
            List<QueryDocumentSnapshot> documents = querySnapshotApiFuture.get().getDocuments();

            List<Client> clientList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                Client client = document.toObject(Client.class);
                clientList.add(client);
            }

            if (clientList.isEmpty()) {
                System.out.println("No clients found in database.");
            } else {
                System.out.println("Clients retrieved from database: " + clientList);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(clientList);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving clients: " + e.getMessage();
        }
    }

    public String create(Client client) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = clientRepository.saveClient(client);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Client saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving client: " + e.getMessage();
        }
    }

    public String update(String documentId, Client client) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = clientRepository.findClientById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = clientRepository.updateClient(documentId, client);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Client updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No client found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating client: " + e.getMessage();
        }
    }

    public String delete(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = clientRepository.findClientById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = clientRepository.deleteClient(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Client deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No client found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting client: " + e.getMessage();
        }
    }
}
