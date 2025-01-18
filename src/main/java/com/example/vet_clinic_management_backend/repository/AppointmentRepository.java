package com.example.vet_clinic_management_backend.repository;

import com.example.vet_clinic_management_backend.entity.Appointment;

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
public class AppointmentRepository {

    @SuppressWarnings("null")
    public ApiFuture<List<Appointment>> findAllAppointments() {
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("appointments").get();

        return ApiFutures.transform(future, querySnapshot -> {
        List<Appointment> appointments = new ArrayList<>();
        
        for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
            Appointment appointment = documentSnapshot.toObject(Appointment.class);
            appointment.setDocumentId(documentSnapshot.getId()); 
            appointments.add(appointment);
        }
        
        return appointments;
    });
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
