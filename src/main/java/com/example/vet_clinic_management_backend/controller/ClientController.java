package com.example.vet_clinic_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet_clinic_management_backend.entity.Client;
import com.example.vet_clinic_management_backend.service.ClientService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Client Module", description = "")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getClientsList() {
        return clientService.getClientList();
    }

    @PostMapping("/create")
    public String createClient(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/update")
    public String updateClient(
            @RequestParam("documentId") String documentId,
            @RequestBody Client client) {
        return clientService.update(documentId, client);
    }

    @DeleteMapping("/delete")
    public String deleteClient(@RequestParam String documentId) {
        return clientService.delete(documentId);
    }
}
