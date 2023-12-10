package com.salmaboubaker.soabackend.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reglements")
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReglement;

    @Temporal(TemporalType.DATE)
    private Date dateReglement;

    private boolean regulationValid;

    @OneToMany(mappedBy = "reglement", cascade = CascadeType.ALL)
    private List<Factures> factures;

    // Constructors, Getters, Setters, and other methods

    public Reglement() {
        // Default constructor
    }

    // Other constructors if needed

    public Long getIdReglement() {
        return idReglement;
    }

    public void setIdReglement(Long idReglement) {
        this.idReglement = idReglement;
    }

    public Date getDateReglement() {
        return dateReglement;
    }

    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public boolean isRegulationValid() {
        return regulationValid;
    }

    public void setRegulationValid(boolean regulationValid) {
        this.regulationValid = regulationValid;
    }

    public List<Factures> getFactures() {
        return factures;
    }

    public void setFactures(List<Factures> factures) {
        this.factures = factures;
    }
}
