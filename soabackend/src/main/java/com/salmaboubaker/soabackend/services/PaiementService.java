package com.salmaboubaker.soabackend.services;

import com.salmaboubaker.soabackend.entities.Paiement;
import com.salmaboubaker.soabackend.repository.PaiementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    public List<Paiement> getPaiementByDate(Date date) {
        return paiementRepository.findByDatePaiement(date);
    }

    public List<Paiement> getReglementByDate(Date date) {
        return paiementRepository.findByDateReglement(date);
    }

    public List<Paiement> getPaiementByRegulationValid() {
        return paiementRepository.findByRegulationValid(true);
    }

    public List<Paiement> getPaiementByReglementNonValid() {
        return paiementRepository.findByRegulationValidFalse();
    }

    public Paiement createPaiement(Paiement paiement) {


        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Long id, Paiement updatedPaiement) {
        Optional<Paiement> existingPaiement = paiementRepository.findById(id);
        if (existingPaiement.isPresent()) {
            Paiement paiement = existingPaiement.get();


            updatedPaiement.setIdPaiement(id);
            return paiementRepository.save(updatedPaiement);
        } else {
            return null;
        }
    }

    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

    private boolean isValidPaiement(Paiement paiement) {

        return paiement != null && paiement.getMontant() > 0;
    }

}
