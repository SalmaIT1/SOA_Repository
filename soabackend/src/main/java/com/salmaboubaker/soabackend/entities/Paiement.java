package com.salmaboubaker.soabackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    private double montant;
    private Date datePaiement;
    private String methodePaiement;
    private String infoCarte;




    public Paiement() {
    }

    public Paiement(Client client, double montant, Date datePaiement, String methodePaiement,
                    String infoCarte, Factures facture, Long idReglement, Date dateReglement) {
        this.client = client;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.methodePaiement = methodePaiement;
        this.infoCarte = infoCarte;

    }



    public Long getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getMethodePaiement() {
        return methodePaiement;
    }

    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }

    public String getInfoCarte() {
        return infoCarte;
    }

    public void setInfoCarte(String infoCarte) {
        this.infoCarte = infoCarte;
    }




}
