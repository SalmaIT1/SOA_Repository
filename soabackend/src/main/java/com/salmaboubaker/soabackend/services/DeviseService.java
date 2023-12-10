package com.salmaboubaker.soabackend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.salmaboubaker.soabackend.entities.Devise;
import com.salmaboubaker.soabackend.repository.DeviseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeviseService {

    private final DeviseRepository deviseRepository;

    public DeviseService(DeviseRepository deviseRepository) {
        this.deviseRepository = deviseRepository;
    }

    public Optional<Devise> trouverDeviseParId(Long id) {
        return deviseRepository.findById(id);
    }

    public List<Devise> trouverDevisesParLibelle(String libelle) {
        return deviseRepository.findByLibelle(libelle);
    }

    public List<Devise> trouverDevisesParPays(String pays) {
        return deviseRepository.findByPays(pays);
    }

    public List<Devise> trouverToutesLesDevises() {
        return deviseRepository.findAll();
    }

    @Transactional
    public Devise ajouterDevise(String libelle, String pays) {
        Devise nouvelleDevise = new Devise();
        nouvelleDevise.setLibelle(libelle);
        nouvelleDevise.setPays(pays);

        return deviseRepository.save(nouvelleDevise);
    }
}
