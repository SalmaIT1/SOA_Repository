package com.salmaboubaker.soabackend.repository;

import com.salmaboubaker.soabackend.entities.StatistiqueClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatistiqueClientRepository extends JpaRepository<StatistiqueClient, Long> {
    StatistiqueClient findByClientId(Long clientId);
}

