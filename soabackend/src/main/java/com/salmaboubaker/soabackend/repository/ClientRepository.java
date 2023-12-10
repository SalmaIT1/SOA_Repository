package com.salmaboubaker.soabackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salmaboubaker.soabackend.entities.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Rechercher un client par son nom
    Optional<Client> findByNom(String nom);


    // Rechercher un client par son adresse email
    Optional<Client> findByEmail(String email);

    // Rechercher un client par son identifiant (id)
    Optional<Client> findById(Long id);

    Client findByEmailAndPassword(String email, String password);
}
