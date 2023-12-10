package com.salmaboubaker.soabackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.salmaboubaker.soabackend.entities.Client;
import com.salmaboubaker.soabackend.services.ClientService;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

   
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.trouverClientParId(id);
    }

    @GetMapping("/byName/{name}")
    public Optional<Client> getClientByName(@PathVariable String name) {
        return clientService.trouverClientParNom(name);
    }
    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
   



}

