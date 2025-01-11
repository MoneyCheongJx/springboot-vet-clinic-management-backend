package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.dto.Appointment;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository {
    
    public ApiFuture<QuerySnapshot> findAllAppointments() {
        return FirestoreClient.getFirestore().collection("appointments").get();
    }

    public ApiFuture<DocumentSnapshot> findAppointmentById(String documentId) {
        return FirestoreClient.getFirestore().collection("appointments").document(documentId).get();
    }

    public ApiFuture<DocumentReference> saveAppointment(Appointment appointment) {
        return FirestoreClient.getFirestore().collection("appointments").add(appointment);
    }

    public ApiFuture<WriteResult> updateAppointment(String documentId, Appointment appointment) {
        return FirestoreClient.getFirestore().collection("appointments").document(documentId).set(appointment);
    }

    public ApiFuture<WriteResult> deleteAppointment(String documentId) {
        return FirestoreClient.getFirestore().collection("appointments").document(documentId).delete();
    }
}
