package com.salmaboubaker.soabackend.repository;

import com.salmaboubaker.soabackend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {



    List<Paiement> findByDatePaiement(Date date);

    // Example custom query method


    // You can add more custom query methods as needed

}
