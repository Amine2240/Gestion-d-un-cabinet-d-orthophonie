package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Date;

public abstract class Patient {
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected String adresse;
    protected ArrayList<Trouble> troublesPatient;
    protected String textDemarcheTherapeutique;
    //protected ArrayList<Bo> listBos;//faire la logique de lanamnese
}
