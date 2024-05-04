package com.example.tp_poo.models;

import java.util.Date;

public class Adulte extends Patient{
    private String diplome;//image plus tard ou select options
    private  String profession;
    private String numeroTel;

    public Adulte(String nom, String prenom, Date dateNaissance, String lieuNaissance, String adresse , String diplome, String profession, String numeroTel) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.diplome = diplome;
        this.profession = profession;
        this.numeroTel = numeroTel;

    }
}
