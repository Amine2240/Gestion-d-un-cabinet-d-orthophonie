package com.example.tp_poo.models;

public abstract class Test {
    private String nom;
    private int capaciteDonnee;
    protected String orthogonisteObservation; //conclusion
    public Test(String nom,String orthogonisteObservation){
        this.nom = nom;
       // this.capaciteDonnee = capaciteDonnee;
        this.orthogonisteObservation = orthogonisteObservation;
    }


    public String getOrthogonisteObservation(){
        return  orthogonisteObservation;
    }
    public void setOrthogonisteObservation(String observation){
        this.orthogonisteObservation = observation;
    }

    public  abstract double calculerScoreTotal(); // entre 1 et 10
}
