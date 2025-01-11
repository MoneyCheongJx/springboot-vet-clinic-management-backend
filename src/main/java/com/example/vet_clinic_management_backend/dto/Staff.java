package com.example.vet_clinic_management_backend.dto;

import com.google.cloud.firestore.annotation.PropertyName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class Staff {
    @PropertyName("fullname")
    @Schema(description = "Full name of the staff member", example = "Wong Teck An")
    private String fullname;

    @PropertyName("phone_number")
    @Schema(description = "Contact phone number", example = "012-3456789")
    private String phoneNumber;

    @Email
    @PropertyName("email")
    @Schema(description = "Email address of the staff member", example = "wongteckan@example.com")
    private String email;

    @PropertyName("address")
    @Schema(description = "Home address of the staff member", example = "17, Jalan 17/2, Seksyen 17")
    private String address;
    
    @PropertyName("city")
    @Schema(description = "City where the staff member resides", example = "Petaling Jaya")
    private String city;
    
    @PropertyName("state")
    @Schema(description = "State where the staff member resides", example = "Selangor")
    private String state;
    
    @PropertyName("postal_code")
    @Schema(description = "Postal code of the staff member's address", example = "46400")
    private String postalCode;

    @PropertyName("age")
    @Schema(description = "Age of the staff member", example = "30")
    private int age;

    @PropertyName("gender")
    @Schema(description = "Gender of the staff member", example = "Male")
    private String gender;

    @PropertyName("role")
    @Schema(description = "Role of the staff member in the clinic", example = "Veterinarian")
    private String role;

    public Staff() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
