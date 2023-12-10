package com.salmaboubaker.soabackend.repository;

import com.salmaboubaker.soabackend.entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    Optional<Reglement> findByDateReglement(Date dateReglement);
    Optional<Reglement> findById(Long idReglement);
}