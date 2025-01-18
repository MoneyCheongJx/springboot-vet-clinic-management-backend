package com.example.vet_clinic_management_backend.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;
import io.swagger.v3.oas.annotations.media.Schema;

public class MedicalInventory {
    @DocumentId
    @Schema(hidden = true)
    private String documentId;

    @PropertyName("name")
    @Schema(description = "Name of the medical item", example = "Antibiotic Syrup")
    private String name;

    @PropertyName("brand")
    @Schema(description = "Brand of the medical item", example = "MedCorp")
    private String brand;

    @PropertyName("quantity")
    @Schema(description = "Quantity of the medical item available in stock", example = "100")
    private int quantity;

    @PropertyName("unit_price")
    @Schema(description = "Unit price of the medical item in RM", example = "2.50")
    private double unitPrice;

    @PropertyName("expiration_date")
    @Schema(description = "Expiration date of the medical item", example = "2025-12-31")
    private String expirationDate;

    @PropertyName("supplier")
    @Schema(description = "Supplier of the medical item", example = "PharmaNiage Sdn. Bhd.")
    private String supplier;

    public MedicalInventory() {
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
