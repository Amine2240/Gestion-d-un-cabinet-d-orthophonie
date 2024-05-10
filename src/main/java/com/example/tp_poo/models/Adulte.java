package com.example.tp_poo.models;

import java.time.LocalDate;
import java.util.Date;

public class Adulte extends Patient{
    private String diplome;//image plus tard ou select options
    private  String profession;
    private String numeroTel;

    public Adulte(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse , String diplome, String profession, String numeroTel) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.diplome = diplome;
        this.profession = profession;
        this.numeroTel = numeroTel;

    }

    public String getDiplome() {
        return diplome;
    }
    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
