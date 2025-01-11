package com.example.vet_clinic_management_backend.dto;

import com.google.cloud.firestore.annotation.PropertyName;
import io.swagger.v3.oas.annotations.media.Schema;

public class PetPatient {
    @PropertyName("owner_fullname")
    @Schema(description = "Full name of the pet's owner", example = "Wong Teck An")
    private String ownerFullname;

    @PropertyName("name")
    @Schema(description = "Name of the pet", example = "Oyen")
    private String name;

    @PropertyName("type")
    @Schema(description = "Type of pet (e.g., Dog, Cat, etc.)", example = "Cat")
    private String type;

    @PropertyName("age")
    @Schema(description = "Age of the pet in years", example = "5")
    private int age;

    @PropertyName("weight")
    @Schema(description = "Weight of the pet in kilograms", example = "3.5")
    private double weight;

    @PropertyName("gender")
    @Schema(description = "Gender of the pet", example = "Female")
    private String gender;

    @PropertyName("color")
    @Schema(description = "Color of the pet", example = "Orange")
    private String color;

    @PropertyName("breed")
    @Schema(description = "Breed of the pet", example = "British Shorthair")
    private String breed;
    
    @PropertyName("birth_date")
    @Schema(description = "Birth date of the pet", example = "2018-05-01")
    private String birthDate;

    @PropertyName("notes")
    @Schema(description = "Additional notes or special considerations for the pet", example = "Has allergies to certain foods")
    private String notes;

    public PetPatient() {
    }

    public String getOwnerFullname() {
        return ownerFullname;
    }

    public void setOwnerFullname(String ownerFullname) {
        this.ownerFullname = ownerFullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
