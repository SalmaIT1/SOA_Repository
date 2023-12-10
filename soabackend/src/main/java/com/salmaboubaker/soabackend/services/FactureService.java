package com.salmaboubaker.soabackend.services;


import org.springframework.stereotype.Service;
import com.salmaboubaker.soabackend.entities.Client;
import com.salmaboubaker.soabackend.entities.Factures;
import com.salmaboubaker.soabackend.repository.FactureRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    private final FactureRepository factureRepository;

   
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Optional<Factures> trouverFactureParId(Long id) {
        return factureRepository.findById(id);
    }

    public List<Factures> trouverFacturesParDate(LocalDate dateFacture) {
        return factureRepository.findByDateFacture(dateFacture);
    }

    public List<Factures> trouverFacturesPourClient(Client client) {
        return factureRepository.findByClient(client);
    }

    // Autres méthodes pour la logique métier liée aux factures
}

