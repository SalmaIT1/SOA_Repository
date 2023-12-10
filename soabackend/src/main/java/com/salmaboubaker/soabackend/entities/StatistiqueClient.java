package com.salmaboubaker.soabackend.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class StatistiqueClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDate date;
    private int nombreVisites;
    private int achatsEffectues;
    private double chiffreAffairesGlobal;
    private double chiffreAffairesAnnee;
    private double montantsNonPayes;
    private int facturesReglees;
    private int facturesNonReglees;
    private String produitsSollicites;

    // Autres statistiques pertinentes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNombreVisites() {
        return nombreVisites;
    }

    public void setNombreVisites(int nombreVisites) {
        this.nombreVisites = nombreVisites;
    }

    public int getAchatsEffectues() {
        return achatsEffectues;
    }

    public void setAchatsEffectues(int achatsEffectues) {
        this.achatsEffectues = achatsEffectues;
    }

    public double getChiffreAffairesGlobal() {
        return chiffreAffairesGlobal;
    }

    public void setChiffreAffairesGlobal(double chiffreAffairesGlobal) {
        this.chiffreAffairesGlobal = chiffreAffairesGlobal;
    }

    public double getChiffreAffairesAnnee() {
        return chiffreAffairesAnnee;
    }

    public void setChiffreAffairesAnnee(double chiffreAffairesAnnee) {
        this.chiffreAffairesAnnee = chiffreAffairesAnnee;
    }

    public double getMontantsNonPayes() {
        return montantsNonPayes;
    }

    public void setMontantsNonPayes(double montantsNonPayes) {
        this.montantsNonPayes = montantsNonPayes;
    }

    public int getFacturesReglees() {
        return facturesReglees;
    }

    public void setFacturesReglees(int facturesReglees) {
        this.facturesReglees = facturesReglees;
    }

    public int getFacturesNonReglees() {
        return facturesNonReglees;
    }

    public void setFacturesNonReglees(int facturesNonReglees) {
        this.facturesNonReglees = facturesNonReglees;
    }

    public String getProduitsSollicites() {
        return produitsSollicites;
    }

    public void setProduitsSollicites(String produitsSollicites) {
        this.produitsSollicites = produitsSollicites;
    }

    // Autres getters et setters pour d'autres attributs si nécessaires
}

