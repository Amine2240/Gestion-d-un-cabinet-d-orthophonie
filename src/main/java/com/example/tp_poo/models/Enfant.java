package com.example.tp_poo.models;
import java.time.LocalDate;
import java.util.Date;

public class Enfant extends Patient{
    private String classEtudes;// enumeration plus tard
    private String numeroMere;
    private String numeroPere;

    public Enfant(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse, String classEtudes, String numeroMere, String numeroPere) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.classEtudes = classEtudes;
        this.numeroMere = numeroMere;
        this.numeroPere = numeroPere;
    }

    public Enfant(String nom, String prenom, int age ) {
        super(nom, prenom, age);
//        this.diplome = diplome;
//        this.profession = profession;
//        this.numeroTel = numeroTel;
    }

    public String getNumeroMere() {
        return numeroMere;
    }
    public void setNumeroMere(String numeroMere) {
        this.numeroMere = numeroMere;
    }

    public String getNumeroPere() {
        return numeroPere;
    }
    public void setNumeroPere(String numeroPere) {
        this.numeroPere = numeroPere;
    }

    public String getClassEtudes() {
        return classEtudes;
    }
    public void setClassEtudes(String classEtudes) {
        this.classEtudes = classEtudes;
    }
}
