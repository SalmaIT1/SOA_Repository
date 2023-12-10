package com.salmaboubaker.soabackend.repository;

import com.salmaboubaker.soabackend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {


    List<Paiement> findByRegulationValid(boolean regulationValid);

    List<Paiement> findByRegulationValidFalse();
    List<Paiement> findByDatePaiement(Date date);

    // Example custom query method
    List<Paiement> findByDateReglement(Date date);

    // You can add more custom query methods as needed

}
