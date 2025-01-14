// package com.example.vet_clinic_management_backend.dto;

// import com.google.cloud.firestore.annotation.PropertyName;
// import io.swagger.v3.oas.annotations.media.Schema;

// public class Ward {
    
//     @PropertyName("name")
//     @Schema(description = "The name of the ward", example = "Canine (Dog) Ward")
//     private String name;

//     @PropertyName("type")
//     @Schema(description = "The type of ward (e.g., General, ICU)", example = "General")
//     private String type; 

//     @PropertyName("capacity")
//     @Schema(description = "The maximum capacity of the ward", example = "10", defaultValue = "10")
//     private int capacity;

//     @PropertyName("current_occupancy")
//     @Schema(description = "The current number of occupants in the ward", example = "5", defaultValue = "0")
//     private int currentOccupancy;

//     public Ward() {
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getType() {
//         return type;
//     }

//     public void setType(String type) {
//         this.type = type;
//     }

//     public int getCapacity() {
//         return capacity;
//     }

//     public void setCapacity(int capacity) {
//         this.capacity = capacity;
//     }

//     public int getCurrentOccupancy() {
//         return currentOccupancy;
//     }

//     public void setCurrentOccupancy(int currentOccupancy) {
//         this.currentOccupancy = currentOccupancy;
//     }
// }
