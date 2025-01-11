package com.example.vet_clinic_management_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vet_clinic_management_backend.dto.Staff;
import com.example.vet_clinic_management_backend.repository.StaffRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public String getStaffList() {
        try {
            ApiFuture<QuerySnapshot> querySnapshotApiFuture = staffRepository.findAllStaffs();
            List<QueryDocumentSnapshot> documents = querySnapshotApiFuture.get().getDocuments();

            List<Staff> staffList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                Staff staff = document.toObject(Staff.class);
                staffList.add(staff);
            }

            if (staffList.isEmpty()) {
                System.out.println("No staffs found in database.");
            } else {
                System.out.println("Staffs retrieved from database: " + staffList);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(staffList);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving staffs: " + e.getMessage();
        }
    }

    public String create(Staff staff) {
        try {
            ApiFuture<DocumentReference> documentReferenceApiFuture = staffRepository.saveStaff(staff);
            DocumentReference documentReference = documentReferenceApiFuture.get();
            return "Staff saved successfully with ID: " + documentReference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving staff: " + e.getMessage();
        }
    }

    public String update(String documentId, Staff staff) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = staffRepository.findStaffById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = staffRepository.updateStaff(documentId, staff);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Staff updated successfully at " + writeResult.getUpdateTime();
            } else {
                return "No staff found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating staff: " + e.getMessage();
        }
    }

    public String delete(String documentId) {
        try {
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = staffRepository.findStaffById(documentId);
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                ApiFuture<WriteResult> writeResultApiFuture = staffRepository.deleteStaff(documentId);
                WriteResult writeResult = writeResultApiFuture.get();
                return "Staff deleted successfully at " + writeResult.getUpdateTime();
            } else {
                return "No staff found with the given ID.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting staff: " + e.getMessage();
        }
    }
}
