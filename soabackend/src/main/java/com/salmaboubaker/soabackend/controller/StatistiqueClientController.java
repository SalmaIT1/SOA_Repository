package com.salmaboubaker.soabackend.controller;

import com.salmaboubaker.soabackend.entities.StatistiqueClient;
import com.salmaboubaker.soabackend.services.StatistiqueClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistiques")
public class StatistiqueClientController {

    private final StatistiqueClientService statistiqueClientService;

    public StatistiqueClientController(StatistiqueClientService statistiqueClientService) {
        this.statistiqueClientService = statistiqueClientService;
    }

    @PostMapping("/client/{clientId}")
    public ResponseEntity<String> creerOuMettreAJourStatistiques(@PathVariable Long clientId,
                                                                 @RequestBody StatistiqueClient statistiqueClient) {
        if (!clientId.equals(statistiqueClient.getClient().getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'ID du client ne correspond pas.");
        }

        statistiqueClientService.calculerEtMettreAJourStatistiques(statistiqueClient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Statistiques mises à jour avec succès pour le client.");
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<StatistiqueClient> obtenirStatistiquesClient(@PathVariable Long clientId) {
        StatistiqueClient statistiqueClient = statistiqueClientService.obtenirStatistiquesParClientId(clientId);

        if (statistiqueClient != null) {
            return ResponseEntity.ok(statistiqueClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // D'autres points de terminaison pour gérer les statistiques des clients si nécessaire
}
