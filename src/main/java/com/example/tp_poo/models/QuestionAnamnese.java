package com.example.tp_poo.models;

public class QuestionAnamnese extends QuestionRpsLibres {
    // elle concerne lanamnese
    private Categories questionCategorie;

    public QuestionAnamnese(String questionEnonce, int scoreQuestion, String reponsePatientLibre , Categories questionCategorie) {
        super(questionEnonce, scoreQuestion, reponsePatientLibre);
        this.questionCategorie = questionCategorie;
    }
}
