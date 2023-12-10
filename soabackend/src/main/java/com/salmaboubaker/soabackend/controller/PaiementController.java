package com.salmaboubaker.soabackend.controller;
import com.salmaboubaker.soabackend.entities.Paiement;
import com.salmaboubaker.soabackend.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/paiements")
public class PaiementController {

    private final PaiementService paiementService;

    @Autowired
    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        Optional<Paiement> paiement = paiementService.getPaiementById(id);
        return paiement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byDate/{date}")
    public List<Paiement> getPaiementByDate(@PathVariable String date) {
        // Convert the string date to a Date object in your service
        return paiementService.getPaiementByDate(convertStringToDate(date));
    }



    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        Paiement createdPaiement = paiementService.createPaiement(paiement);
        return new ResponseEntity<>(createdPaiement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement updatedPaiement) {
        Paiement updated = paiementService.updatePaiement(id, updatedPaiement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Utility method to convert String to Date
    private Date convertStringToDate(String dateString) {
        // Implement the logic to convert the string date to a Date object
        // You can use SimpleDateFormat or other methods based on your requirements
        return null; // Replace this with your actual conversion logic
    }
}
