package com.salmaboubaker.soabackend.controller;

import org.springframework.web.bind.annotation.*;
import com.salmaboubaker.soabackend.entities.Client;
import com.salmaboubaker.soabackend.entities.Factures;
import com.salmaboubaker.soabackend.services.FactureService;
import com.salmaboubaker.soabackend.services.ClientService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/factures")
public class FactureController {

    private final FactureService factureService;
    private final ClientService clientService;

    
    public FactureController(FactureService factureService, ClientService clientService) {
        this.factureService = factureService;
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Optional<Factures> getFactureById(@PathVariable Long id) {
        return factureService.trouverFactureParId(id);
    }

    @GetMapping("/byDate/{dateFacture}")
    public List<Factures> getFacturesByDate(@PathVariable LocalDate dateFacture) {
        return factureService.trouverFacturesParDate(dateFacture);
    }

    @GetMapping("/byClient/{clientId}")
    public List<Factures> getFacturesByClient(@PathVariable Long clientId) {
        Optional<Client> client = clientService.trouverClientParId(clientId);
        if (client.isPresent()) {
            return factureService.trouverFacturesPourClient(client.get());
        } else {
            // Handle client not found scenario
            return null; // Or you can return an appropriate response
        }
    }

    // Other endpoints for different operations related to factures
}

