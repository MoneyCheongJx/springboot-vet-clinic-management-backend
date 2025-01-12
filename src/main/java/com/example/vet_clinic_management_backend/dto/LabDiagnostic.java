package com.example.vet_clinic_management_backend.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;

import io.swagger.v3.oas.annotations.media.Schema;

public class LabDiagnostic {
    @DocumentId
    @Schema(hidden = true)
    private String documentId;

    @PropertyName("owner_fullname")
    @Schema(description = "Full name of the pet's owner", example = "Wong Teck An")
    private String ownerFullname;

    @PropertyName("pet_name")
    @Schema(description = "Name of the pet", example = "Oyen")
    private String petName;

    @PropertyName("pet_type")
    @Schema(description = "Type of pet (e.g., Dog, Cat, etc.)", example = "Cat")
    private String petType;

    @PropertyName("age")
    @Schema(description = "Age of the pet in years", example = "5")
    private int age;

    @PropertyName("pet_gender")
    @Schema(description = "Gender of the pet", example = "Female")
    private String petGender;

    @PropertyName("diagnostic_test")
    @Schema(description = "Name of the diagnostic test performed", example = "Blood Test")
    private String diagnosticTest;

    @PropertyName("result")
    @Schema(description = "Result of the diagnostic test", example = "Normal")
    private String result;

    @PropertyName("date")
    @Schema(description = "Date when the diagnostic test was performed", example = "2025-01-10")
    private String date;

    public LabDiagnostic() {
    }

    public String getOwnerFullname() {
        return ownerFullname;
    }

    public void setOwnerFullname(String ownerFullname) {
        this.ownerFullname = ownerFullname;
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

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getDiagnosticTest() {
        return diagnosticTest;
    }

    public void setDiagnosticTest(String diagnosticTest) {
        this.diagnosticTest = diagnosticTest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

}
