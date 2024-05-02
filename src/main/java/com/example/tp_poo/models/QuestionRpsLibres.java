package com.example.tp_poo.models;

public class QuestionRpsLibres extends Question{
    private String reponsePatientLibre;

    public QuestionRpsLibres(String questionEnonce, int scoreQuestion , String reponsePatientLibre) {
        super(questionEnonce, scoreQuestion);
        this.reponsePatientLibre = reponsePatientLibre;
    }
}
