// package com.example.vet_clinic_management_backend.repository;

// import com.example.vet_clinic_management_backend.dto.Staff;

// import com.google.api.core.ApiFuture;

// import com.google.cloud.firestore.DocumentReference;
// import com.google.cloud.firestore.DocumentSnapshot;
// import com.google.cloud.firestore.QuerySnapshot;
// import com.google.cloud.firestore.WriteResult;

// import com.google.firebase.cloud.FirestoreClient;
// import org.springframework.stereotype.Repository;

// @Repository
// public class StaffRepository {
    
//     public ApiFuture<QuerySnapshot> findAllStaffs() {
//         return FirestoreClient.getFirestore().collection("staffs").get();
//     }

//     public ApiFuture<DocumentSnapshot> findStaffById(String documentId) {
//         return FirestoreClient.getFirestore().collection("staffs").document(documentId).get();
//     }

//     public ApiFuture<DocumentReference> saveStaff(Staff staff) {
//         return FirestoreClient.getFirestore().collection("staffs").add(staff);
//     }

//     public ApiFuture<WriteResult> updateStaff(String documentId, Staff staff) {
//         return FirestoreClient.getFirestore().collection("staffs").document(documentId).set(staff);
//     }

//     public ApiFuture<WriteResult> deleteStaff(String documentId) {
//         return FirestoreClient.getFirestore().collection("staffs").document(documentId).delete();
//     }
// }
