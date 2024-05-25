package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Set;

public class DossierPatient {
    private  int numeroDossier;
    private static int numeroDossierIncrement = 0;
    private Patient patient;
    private ArrayList<Bo> listBos;//faire la logique de lanamnese
    private ArrayList<RendezVous> listRdvous;
    private ArrayList<FicheSuivi> listFicheSuivis;
    public DossierPatient( Patient patient, ArrayList<Bo> listBos, ArrayList<RendezVous> listRdvous, ArrayList<FicheSuivi> listFicheSuivis) {
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

    public ArrayList<RendezVous> getListRdvous() {
        return listRdvous;
    }
    public void setListRdvous(ArrayList<RendezVous> listRdvous) {
        this.listRdvous = listRdvous;
    }
    public ArrayList<Bo> getListBos() {
        return listBos;
    }
    public ArrayList<FicheSuivi> getListFicheSuivis() {
        return listFicheSuivis;
    }
    //    public void incrementNumeroDossier() {
//
//    }
}
