package com.example.tp_poo.models;
import java.util.Date;

public class Enfant extends Patient{
    private String classEtudes;// enumeration plus tard
    private String numeroMere;
    private String numeroPere;

    public Enfant(String nom, String prenom, Date dateNaissance, String lieuNaissance, String adresse, String classEtudes, String numeroMere, String numeroPere) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.classEtudes = classEtudes;
        this.numeroMere = numeroMere;
        this.numeroPere = numeroPere;
    }
}
