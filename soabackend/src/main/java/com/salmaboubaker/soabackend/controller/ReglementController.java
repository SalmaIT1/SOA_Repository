package com.salmaboubaker.soabackend.controller;

import com.salmaboubaker.soabackend.entities.Reglement;
import com.salmaboubaker.soabackend.services.ReglementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reglements")
public class ReglementController {

    private final ReglementService reglementService;

    @Autowired
    public ReglementController(ReglementService reglementService) {
        this.reglementService = reglementService;
    }

    @GetMapping
    public ResponseEntity<List<Reglement>> getAllReglements() {
        List<Reglement> reglements = reglementService.getAllReglements();
        return new ResponseEntity<>(reglements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reglement> getReglementById(@PathVariable Long id) {
        Optional<Reglement> reglement = reglementService.getReglementById(id);
        return reglement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reglement> createReglement(@RequestBody Reglement reglement) {
        Reglement createdReglement = reglementService.createReglement(reglement);
        return new ResponseEntity<>(createdReglement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reglement> updateReglement(@PathVariable Long id, @RequestBody Reglement updatedReglement) {
        Reglement updated = reglementService.updateReglement(id, updatedReglement);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReglement(@PathVariable Long id) {
        boolean deleted = reglementService.deleteReglement(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
