package com.example.tp_poo.models;

public class AnamneseAdulte extends  Anamnese{
    private  String histoireMaladie;
    //private suivi
    // liste des questions concernant son histoire de sa maladie
    public AnamneseAdulte(String histoireMaladie) {
        this.histoireMaladie = histoireMaladie;
    }
}
