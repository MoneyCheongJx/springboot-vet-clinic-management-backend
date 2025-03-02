package com.example.vet_clinic_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.entity.Appointment;
import com.example.vet_clinic_management_backend.repository.AppointmentRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    public String getAppointmentList() {
        try {
            ApiFuture<List<Appointment>> appointmentFuture = appointmentRepository.findAllAppointments();
            List<Appointment> appointmentList = appointmentFuture.get(); 
    
            if (appointmentList.isEmpty()) {
                System.out.println("No appointments found in database.");
            } else {
                System.out.println("Appointments retrieved from database: " + appointmentList);
            }
    
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(appointmentList);
    
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving appointments: " + e.getMessage();
        }
    }

    public String createAppointment(Appointment appointment) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = appointmentRepository.saveAppointment(appointment);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Appointment saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving appointment: " + e.getMessage();
        }
    }

    public String updateAppointment(String documentId, Appointment appointment) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = appointmentRepository.findAppointmentById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = appointmentRepository.updateAppointment(documentId, appointment);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Appointment updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No appointment found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating appointment: " + e.getMessage();
        }
    }

    public String deleteAppointment(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = appointmentRepository.findAppointmentById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = appointmentRepository.deleteAppointment(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Appointment deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No appointment found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting appointment: " + e.getMessage();
        }
    }
}
