package com.salmaboubaker.soabackend.entities;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private String designation;
    private Double prix;
    private Integer qtestock;
    private String marque;
    private String image;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Factures factures;

    public Product() {

    }

    public Product(String reference, String designation, Double prix, Integer qtestock, String marque, String image) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
        this.qtestock = qtestock;
        this.marque = marque;
        this.image = image;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQtestock() {
        return qtestock;
    }

    public void setQtestock(Integer qtestock) {
        this.qtestock = qtestock;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
