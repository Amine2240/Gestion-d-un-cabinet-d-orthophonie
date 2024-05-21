package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Set;

public class DossierPatient {
    private  int numeroDossier;
    private static int numeroDossierIncrement = 0;
    private Patient patient;
    private ArrayList<Bo> listBos;//faire la logique de lanamnese
    private Set<RendezVous> listRdvous;
    private ArrayList<FicheSuivi> listFicheSuivis;
    public DossierPatient( Patient patient, ArrayList<Bo> listBos, Set<RendezVous> listRdvous, ArrayList<FicheSuivi> listFicheSuivis) {
        setNumeroDossier();
//        incrementNumeroDossier();
        this.patient = patient;
        this.listBos = listBos;
        this.listRdvous = listRdvous;
        this.listFicheSuivis = listFicheSuivis;
        setNumeroDossier();
    }
    public int getNumeroDossier() {
        return numeroDossier;
    }
    public void setNumeroDossier() {
        numeroDossierIncrement = numeroDossierIncrement + 1 ;
        this.numeroDossier = numeroDossierIncrement;
    }
    public Patient getPatient() {
        return patient;
    }

    public Set<RendezVous> getListRdvous() {
        return listRdvous;
    }
    public ArrayList<Bo> getListBos() {
        return listBos;
    }
    //    public void incrementNumeroDossier() {
//
//    }
}
