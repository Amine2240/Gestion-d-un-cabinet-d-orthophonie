package com.example.tp_poo.models;

public class QuestionAnamnese extends QuestionRpsLibres {
    // elle concerne lanamnese
    private Categories questionCategorie;

    public QuestionAnamnese(String questionEnonce , Categories questionCategorie) {
        super(questionEnonce);
        this.questionCategorie = questionCategorie;
    }
}
