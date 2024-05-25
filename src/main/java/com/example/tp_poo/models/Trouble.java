package com.example.tp_poo.models;

public class Trouble {
    private String nomTrouble;
    private TroubleCategries troubleCategorie;
    public Trouble(String nomTrouble , TroubleCategries troubleCategorie){
        this.nomTrouble = nomTrouble;
        this.troubleCategorie = troubleCategorie;
    }
    public String getNomTrouble() {
        return nomTrouble;
    }
    public TroubleCategries getTroubleCategorie() {
        return troubleCategorie;
    }
}
