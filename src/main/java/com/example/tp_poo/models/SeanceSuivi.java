package com.example.tp_poo.models;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class SeanceSuivi extends RendezVous {
    private Deroulement typeSeance;
    private int numeroDossierPatient; // ou bien le dossier ou bien le patient
    private FicheSuivi ficheSuivi;
    public SeanceSuivi(LocalDate date , LocalTime heureDebut,  Deroulement typeSeance , Patient patient){
        super(date , heureDebut  , patient);
        this.typeSeance = typeSeance;

    }
    public Deroulement getTypeSeance() {
        return typeSeance;
    }
    public FicheSuivi getFicheSuivi() {
        return ficheSuivi;
    }
    public void setFicheSuivi(FicheSuivi ficheSuivi) {
        this.ficheSuivi = ficheSuivi;
    }
    public int getNumeroDossierPatient() {
        return numeroDossierPatient;
    }
    public void setNumeroDossierPatient(int numeroDossierPatient) {
        this.numeroDossierPatient = numeroDossierPatient;
    }
}
