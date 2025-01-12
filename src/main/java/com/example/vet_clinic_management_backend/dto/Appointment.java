package com.example.vet_clinic_management_backend.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;

import io.swagger.v3.oas.annotations.media.Schema;

public class Appointment {

    @DocumentId
    @Schema(hidden = true)
    private String documentId;

    @PropertyName("owner_fullname")
    @Schema(description = "Full name of the pet's owner", example = "Wong Teck An")
    private String ownerFullname;

    @PropertyName("email")
    @Schema(description = "Email address of the pet's owner", example = "wongteckan@example.com")
    private String email;

    @PropertyName("phone_number")
    @Schema(description = "Phone number of the pet's owner", example = "012-3456789")
    private String phoneNumber;

    @PropertyName("date")
    @Schema(description = "Date of the appointment", example = "2025-01-15")
    private String date;

    @PropertyName("time")
    @Schema(description = "Time of the appointment", example = "10:00")
    private String time;

    @PropertyName("pet_name")
    @Schema(description = "Name of the pet", example = "Oyen")
    private String petName;

    @PropertyName("pet_type")
    @Schema(description = "Type of pet (e.g., Dog, Cat)", example = "Cat")
    private String petType;

    @PropertyName("pet_age")
    @Schema(description = "Age of the pet in years", example = "5")
    private Integer petAge;

    @PropertyName("pet_weight")
    @Schema(description = "Weight of the pet in kilograms", example = "3.5")
    private Double petWeight;

    @PropertyName("pet_gender")
    @Schema(description = "Gender of the pet", example = "Female")
    private String petGender;

    @PropertyName("purpose")
    @Schema(description = "Purpose of the appointment", example = "Routine check-up")
    private String purpose;

    @PropertyName("notes")
    @Schema(description = "Additional notes for the appointment", example = "Pet is due for vaccination")
    private String notes;

    public Appointment() {
    }

    public String getOwnerFullname() {
        return ownerFullname;
    }

    public void setOwnerFullname(String ownerFullname) {
        this.ownerFullname = ownerFullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public Double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Double petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
