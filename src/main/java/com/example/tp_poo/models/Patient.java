package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Date;

public abstract class Patient {
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected String adresse;
    public Patient(String nom, String prenom, Date dateNaissance, String lieuNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
    }
    //protected DossierPatient dossierPatient;
    //protected ArrayList<Trouble> troublesPatient;
    //protected String textDemarcheTherapeutique;
    //protected ArrayList<Bo> listBos;
}
