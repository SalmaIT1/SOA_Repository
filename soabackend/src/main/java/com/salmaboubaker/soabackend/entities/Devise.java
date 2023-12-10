package com.salmaboubaker.soabackend.entities;

import jakarta.persistence.*;

@Entity
public class Devise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devise")
    private Long id;

    @Column(name = "libelle_devise")
    private String libelle;

    @Column(name = "pays_devise")
    private String pays;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
