package com.salmaboubaker.soabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salmaboubaker.soabackend.entities.Client;
import com.salmaboubaker.soabackend.entities.Factures;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Factures, Long> {

    // Rechercher une facture par son identifiant (id)
    Optional<Factures> findById(Long id);

    // Rechercher les factures par la date
    List<Factures> findByDateFacture(LocalDate dateFacture);

    // Rechercher les factures pour un client donné
    List<Factures> findByClient(Client client);

    List<Factures> findByClientIdAndPayeeFalse(Long id);

    List<Factures> findByClientIdAndPayeeTrue(Long id);

    List<Factures> findByClientId(Long id);

    List<Factures> findAll();

}
