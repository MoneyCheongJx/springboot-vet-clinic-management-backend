package com.example.vet_clinic_management_backend.service;

import com.example.vet_clinic_management_backend.entity.LabDiagnostic;

public interface LabDiagnosticService {
    String getLabDiagnosticList();
    String createLabDiagnostic(LabDiagnostic labDiagnostic);
    String updateLabDiagnostic(String documentId, LabDiagnostic labDiagnostic);
    String deleteLabDiagnostic(String documentId);
}
