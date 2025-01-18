package com.example.vet_clinic_management_backend.service;

import com.example.vet_clinic_management_backend.entity.Client;

public interface ClientService {
    String getClientList();
    String createClient(Client client);
    String updateClient(String documentId, Client client);
    String deleteClient(String documentId);
}
