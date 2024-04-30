package com.example.tp_poo.models;

public class Exercice {
    private  String nomExo;
    private String consigneExo;
    private String nomMaterielExo;
    protected int scoreExercice; // il sera modifie par lorthogoniste (avec exception)

    public String getNomExo() {
        return nomExo;
    }
}
