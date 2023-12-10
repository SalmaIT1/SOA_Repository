package com.salmaboubaker.soabackend.services;


import com.salmaboubaker.soabackend.entities.Reglement;
import com.salmaboubaker.soabackend.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReglementService {

    private final ReglementRepository reglementRepository;

    @Autowired
    public ReglementService(ReglementRepository reglementRepository) {
        this.reglementRepository = reglementRepository;
    }

    public List<Reglement> getAllReglements() {
        return reglementRepository.findAll();
    }

    public Optional<Reglement> getReglementById(Long id) {
        return reglementRepository.findById(id);
    }

    public Reglement createReglement(Reglement reglement) {
        return reglementRepository.save(reglement);
    }

    public Reglement updateReglement(Long id, Reglement updatedReglement) {
        Optional<Reglement> existingReglementOptional = reglementRepository.findById(id);
        if (existingReglementOptional.isPresent()) {
            updatedReglement.setIdReglement(id);
            return reglementRepository.save(updatedReglement);
        }
        return null; // or throw an exception indicating the resource was not found
    }

    public boolean deleteReglement(Long id) {
        Optional<Reglement> reglementOptional = reglementRepository.findById(id);
        if (reglementOptional.isPresent()) {
            reglementRepository.deleteById(id);
            return true;
        }
        return false; // or throw an exception indicating the resource was not found
    }
}
