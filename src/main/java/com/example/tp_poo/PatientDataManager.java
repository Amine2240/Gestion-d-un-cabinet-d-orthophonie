package com.example.tp_poo;

import com.example.tp_poo.models.Adulte;
import com.example.tp_poo.models.DossierPatient;
import com.example.tp_poo.models.Enfant;
import com.example.tp_poo.models.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDataManager {
    private static PatientDataManager instance;


    LocalDate date1 = LocalDate.of(2000, 1, 1);
    LocalDate date2 = LocalDate.of(2001, 2, 2);
    LocalDate date3 = LocalDate.of(2002, 3, 3);
    LocalDate date4 = LocalDate.of(2003, 4, 4);

    Enfant p1 = new Enfant("kadoum", "amine", date1, "Paris", "123 Main St", "Primary", "0552484650", "0541177916");
    Enfant p2 = new Enfant("lattari", "alenas", date2, "London", "456 Elm St", "Secondary", "0552484650", "0541177916");
    Enfant p3 = new Enfant("nemamcha", "oussama", date3, "New York", "789 Oak St", "Primary", "0552484650", "0541177916");
    Enfant p4 = new Enfant("khiali", "imad", date4, "Berlin", "101 Pine St", "Secondary", "0552484650", "0541177916");

    Adulte a1 = new Adulte("kadoum", "kamel", date1, "Paris", "123 Main St", "doctorat", "architecte", "0541177916");
    Adulte a2 = new Adulte("boudraa", "mourad", date2, "London", "456 Elm St", "liscence", "medecin", "0541177916");
    Adulte a3 = new Adulte("aouni", "djamel", date3, "New York", "789 Oak St", "bacallauriat", "ingenieur", "0541177916");
    Adulte a4 = new Adulte("Emily", "Brown", date4, "Berlin", "101 Pine St", "master", "professeur", "0541177916");

    Adulte pp1 = new Adulte("becharai", "khalil", 25);
    Enfant pp2 = new Enfant("allag", "yacine", 10);
    Adulte pp3 = new Adulte("bougussa", "wail", 35);
    Enfant pp4 = new Enfant("rabia", "manil", 13);

    DossierPatient dossierPatientp1 = new DossierPatient(p1 , null, null, null);
    DossierPatient dossierPatientp2 = new DossierPatient(p2 , null, null, null);
    DossierPatient dossierPatientp3 = new DossierPatient(p3 , null, null, null);
    DossierPatient dossierPatientp4 = new DossierPatient(p4 , null, null, null);
    DossierPatient dossierPatienta1 = new DossierPatient(a1 , null, null, null);
    DossierPatient dossierPatienta2 = new DossierPatient(a2 , null, null, null);
    DossierPatient dossierPatienta3 = new DossierPatient(a3 , null, null, null);
    DossierPatient dossierPatienta4 = new DossierPatient(a4 , null, null, null);

//    ArrayList<DossierPatient> dossierPatients = new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4));
//    ArrayList<Patient> listPatientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
    ArrayList<Patient> listPatientsIncomplet = new ArrayList<>(List.of(pp1, pp2, pp3, pp4));

    private List<Patient> patientsIncomplet = new ArrayList<>(List.of(pp1, pp2, pp3, pp4));
    private List<Patient> patientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
    private List<DossierPatient>  dossierPatients = new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4));
    // Other necessary fields and methods

    private PatientDataManager() {
        // Initialize your data here
    }

    public static PatientDataManager getInstance() {
        if (instance == null) {
            instance = new PatientDataManager();
        }
        return instance;
    }

    // Add methods to access and modify patient data
    public List<Patient> getPatientsIncomplet() {
        return patientsIncomplet;
    }

    public void setPatientsIncomplet(List<Patient> patientsIncomplet) {
        this.patientsIncomplet = patientsIncomplet;
    }
    public List<Patient> getPatientsComplet() {
        return patientsComplet;
    }
    public void setPatientsComplet(List<Patient> patientsComplet) {
        this.patientsComplet = patientsComplet;
    }
    public List<DossierPatient> getDossierPatient() {
        return new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4));
    }
    public void setDossierPatient(List<DossierPatient> dossierPatients) {
        this.dossierPatients = dossierPatients;
    }
    public void addPatient(Patient patient) {
        patientsComplet.add(patient);
    }

    public void setDossierToPatients(){
        for (int i = 0; i < patientsComplet.size(); i++) {
            patientsComplet.get(i).setDossierPatient(dossierPatients.get(i));
        }
    }
    public void addDossierPatient(DossierPatient dossierPatient) {
        dossierPatients.add(dossierPatient);

    }

    // Sim
}
