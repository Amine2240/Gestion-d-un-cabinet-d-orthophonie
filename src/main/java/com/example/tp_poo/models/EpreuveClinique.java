package com.example.tp_poo.models;

import java.util.ArrayList;

public class EpreuveClinique {
    private String observationClinique; // redige par lorthogoniste (methode dans la classe orthogoniste)
    private ArrayList<Test> listTests;
    public EpreuveClinique(String observationClinique , ArrayList<Test> listTests){
        this.listTests = listTests;
        this.observationClinique = observationClinique;

    }
}
