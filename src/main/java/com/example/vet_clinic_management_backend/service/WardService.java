// package com.example.vet_clinic_management_backend.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.vet_clinic_management_backend.dto.Ward;
// import com.example.vet_clinic_management_backend.repository.WardRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.api.core.ApiFuture;
// import com.google.cloud.firestore.DocumentReference;
// import com.google.cloud.firestore.DocumentSnapshot;
// import com.google.cloud.firestore.QueryDocumentSnapshot;
// import com.google.cloud.firestore.QuerySnapshot;
// import com.google.cloud.firestore.WriteResult;

// @Service
// public class WardService {

//     @Autowired
//     private WardRepository wardRepository;

//     public String getWardList() {
//         try {
//             ApiFuture<QuerySnapshot> querySnapshotApiFuture = wardRepository.findAllWards();
//             List<QueryDocumentSnapshot> documents = querySnapshotApiFuture.get().getDocuments();

//             List<Ward> wardList = new ArrayList<>();
//             for (QueryDocumentSnapshot document : documents) {
//                 Ward ward = document.toObject(Ward.class);
//                 wardList.add(ward);
//             }

//             if (wardList.isEmpty()) {
//                 System.out.println("No wards found in database.");
//             } else {
//                 System.out.println("Wards retrieved from database: " + wardList);
//             }

//             ObjectMapper objectMapper = new ObjectMapper();
//             return objectMapper.writeValueAsString(wardList);

//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error retrieving wards: " + e.getMessage();
//         }
//     }

//     public String create(Ward ward) {
//         try {
//             ApiFuture<DocumentReference> documentReferenceApiFuture = wardRepository.saveWard(ward);
//             DocumentReference documentReference = documentReferenceApiFuture.get();
//             return "Ward saved successfully with ID: " + documentReference.getId();
//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error saving ward: " + e.getMessage();
//         }
//     }

//     public String update(String documentId, Ward ward) {
//         try {
//             ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = wardRepository.findWardById(documentId);
//             DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

//             if (documentSnapshot.exists()) {
//                 ApiFuture<WriteResult> writeResultApiFuture = wardRepository.updateWard(documentId, ward);
//                 WriteResult writeResult = writeResultApiFuture.get();
//                 return "Ward updated successfully at " + writeResult.getUpdateTime();
//             } else {
//                 return "No ward found with the given ID.";
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error updating ward: " + e.getMessage();
//         }
//     }

//     public String delete(String documentId) {
//         try {
//             ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = wardRepository.findWardById(documentId);
//             DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

//             if (documentSnapshot.exists()) {
//                 ApiFuture<WriteResult> writeResultApiFuture = wardRepository.deleteWard(documentId);
//                 WriteResult writeResult = writeResultApiFuture.get();
//                 return "Ward deleted successfully at " + writeResult.getUpdateTime();
//             } else {
//                 return "No ward found with the given ID.";
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error deleting ward: " + e.getMessage();
//         }
//     }
// }
