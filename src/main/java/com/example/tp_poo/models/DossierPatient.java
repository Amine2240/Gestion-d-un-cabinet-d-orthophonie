package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Set;

public class DossierPatient {
    private  int numeroDossier;
    private Patient patient;
    private ArrayList<Bo> listBos;//faire la logique de lanamnese
    private Set<RendezVous> listRdvous;
    private ArrayList<FicheSuivi> listFicheSuivis;
}
