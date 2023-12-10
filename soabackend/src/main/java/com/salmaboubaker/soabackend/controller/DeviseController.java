package com.salmaboubaker.soabackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.salmaboubaker.soabackend.entities.Devise;
import com.salmaboubaker.soabackend.services.DeviseService;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/devises")
public class DeviseController {

    private final DeviseService deviseService;

    public DeviseController(DeviseService deviseService) {
        this.deviseService = deviseService;
    }

    @GetMapping("/{id}")
    public Optional<Devise> getDeviseById(@PathVariable Long id) {
        return deviseService.trouverDeviseParId(id);
    }

    @GetMapping("/byLibelle/{libelle}")
    public List<Devise> getDevisesByLibelle(@PathVariable String libelle) {
        return deviseService.trouverDevisesParLibelle(libelle);
    }

    @GetMapping("/byPays/{pays}")
    public List<Devise> getDevisesByPays(@PathVariable String pays) {
        return deviseService.trouverDevisesParPays(pays);
    }

    @GetMapping("/all")
    public List<Devise> getAllDevises() {
        return deviseService.trouverToutesLesDevises();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDevises(
            @RequestParam(name = "libelle") String libelle,
            @RequestParam(name = "pays") String pays) {
        try {
            deviseService.ajouterDevise(libelle, pays);
            return ResponseEntity.ok("Devise added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding devise");
        }
    }


}
