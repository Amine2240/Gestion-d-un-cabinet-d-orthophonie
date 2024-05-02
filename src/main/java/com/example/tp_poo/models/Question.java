package com.example.tp_poo.models;

public abstract class Question {
    protected String questionEnonce;
    protected int scoreQuestion; // il sera modifie par lorthogoniste (avec exception)

    public Question(String questionEnonce, int scoreQuestion) {
        this.questionEnonce = questionEnonce;
        this.scoreQuestion = scoreQuestion;
    }


}
