package com.example.tp_poo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Patient {
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String lieuNaissance;
    protected String adresse;
    public Patient(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
    }
    public String getNom() {
        return nom;
    };
    public String getPrenom() {
        return prenom;
    };
    public LocalDate getDateNaissance() {
        return dateNaissance;
    };
    public String getLieuNaissance() {
        return lieuNaissance;
    };
    public String getAdresse() {
        return adresse;
    };

    //protected DossierPatient dossierPatient;
    //protected ArrayList<Trouble> troublesPatient;
    //protected String textDemarcheTherapeutique;
    //protected ArrayList<Bo> listBos;
}
