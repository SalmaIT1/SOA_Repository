package com.salmaboubaker.soabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salmaboubaker.soabackend.entities.Devise;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long> {

    Optional<Devise> findById(Long id);

    List<Devise> findByLibelle(String libelle);

    List<Devise> findByPays(String pays);

    List<Devise> findAll(); // Added method to retrieve all Devises
}
