package com.salmaboubaker.soabackend.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Factures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateFacture;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "factures", cascade = CascadeType.ALL)
    private List<Product> Products;

    private double montantTotal;
    private double montantRestant;
    @Enumerated(EnumType.STRING)
    private StatutPaiement statutPaiement;
    private Long idReglement;
    private Date dateReglement;
    private boolean regulationValid;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> Products) {
        this.Products = Products;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public StatutPaiement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutPaiement statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public double getMontantRestant() {

        return montantRestant;
    }

    public enum StatutPaiement {
        PAYEE,
        NON_PAYEE
    }
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
}
