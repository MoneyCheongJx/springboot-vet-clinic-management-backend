package com.example.vet_clinic_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet_clinic_management_backend.entity.Appointment;
import com.example.vet_clinic_management_backend.service.AppointmentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Appointment Module", description = "")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String getAppointmentsList() {
        return appointmentService.getAppointmentList();
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/update")
    public String updateAppointment(
            @RequestParam("documentId") String documentId,
            @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(documentId, appointment);
    }

    @DeleteMapping("/delete")
    public String deleteAppointment(@RequestParam String documentId) {
        return appointmentService.deleteAppointment(documentId);
    }
}
