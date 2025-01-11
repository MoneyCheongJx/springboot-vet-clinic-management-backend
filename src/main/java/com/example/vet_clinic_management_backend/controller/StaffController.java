package com.example.vet_clinic_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet_clinic_management_backend.dto.Staff;
import com.example.vet_clinic_management_backend.service.StaffService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Staff Module", description = "")
@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String getStaffList() {
        return staffService.getStaffList();
    }

    @PostMapping("/create")
    public String createStaff(@RequestBody Staff staff) {
        return staffService.create(staff);
    }

    @PutMapping("/update")
    public String updateStaff(
            @RequestParam("documentId") String documentId,
            @RequestBody Staff staff) {
        return staffService.update(documentId, staff);
    }

    @DeleteMapping("/delete")
    public String deleteStaff(@RequestParam String documentId) {
        return staffService.delete(documentId);
    }
}
