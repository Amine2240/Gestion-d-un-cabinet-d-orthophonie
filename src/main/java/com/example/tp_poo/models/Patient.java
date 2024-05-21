package com.example.tp_poo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Patient {
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String lieuNaissance;
    protected String adresse;
    protected DossierPatient dossierPatient;
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
    public DossierPatient getDossierPatient() {
        return dossierPatient;
    };
    public void setDossierPatient(DossierPatient dossierPatient) {
        this.dossierPatient = dossierPatient;
    };

    public static String identifyPatient(Patient patient) {
        if (patient instanceof Adulte) {
            return "adulte";
        } else if (patient instanceof Enfant) {
            return "enfant";
        } else {
            return "unknown";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(nom, patient.nom) &&
                Objects.equals(prenom, patient.prenom) ;
               //&& Objects.equals(dateNaissance, patient.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dateNaissance);
    }

    //protected DossierPatient dossierPatient;
    //protected ArrayList<Trouble> troublesPatient;
    //protected String textDemarcheTherapeutique;
    //protected ArrayList<Bo> listBos;
}
