package com.example.vet_clinic_management_backend.service;

import com.example.vet_clinic_management_backend.entity.Appointment;

public interface AppointmentService {
    String getAppointmentList();
    String createAppointment(Appointment appointment);
    String updateAppointment(String documentId, Appointment appointment);
    String deleteAppointment(String documentId);
}
