package com.example.tp_poo.models;

import java.sql.Time;
import java.util.Date;

public class SeanceSuivi extends RendezVous {
    private Deroulement typeSeance;
    private int numeroDossierPatient; // ou bien le dossier ou bien le patient
    private FicheSuivi ficheSuivi;
    public SeanceSuivi(Date date , Time heure, Deroulement typeSeance){
        super(date , heure );
        this.typeSeance = typeSeance;

    }
}
