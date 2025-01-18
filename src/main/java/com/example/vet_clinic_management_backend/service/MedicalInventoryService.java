package com.example.vet_clinic_management_backend.service;

import com.example.vet_clinic_management_backend.entity.MedicalInventory;

public interface MedicalInventoryService {
    String getMedicalInventoryList();
    String createMedicalInventory(MedicalInventory medicalInventory);
    String updateMedicalInventory(String documentId, MedicalInventory medicalInventory);
    String deleteMedicalInventory(String documentId);
}
