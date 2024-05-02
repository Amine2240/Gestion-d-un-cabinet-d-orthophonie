package com.example.tp_poo.models;

public class Exercice {
    private  String nomExo;
    private String consigneExo;
    private String nomMaterielExo;
    protected int scoreExercice; // il sera modifie par lorthogoniste (avec exception)
    public Exercice(String nomExo, String consigneExo, String nomMaterielExo ) {
        this.nomExo = nomExo;
        this.consigneExo = consigneExo;
        this.nomMaterielExo = nomMaterielExo;
      //  this.scoreExercice = scoreExercice;

    }

    public String getNomExo() {
        return nomExo;
    }
}
