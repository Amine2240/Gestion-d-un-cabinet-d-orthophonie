package com.example.tp_poo.models;

public abstract class Question {
    protected String questionEnonce;
    protected double scoreQuestion; // il sera modifie par lorthogoniste (avec exception)

    public Question(String questionEnonce) {
        this.questionEnonce = questionEnonce;
       // this.scoreQuestion = scoreQuestion;
    }

    public void setScoreQuestion(double scoreQuestion) throws Exception1 {
        try {
            if (scoreQuestion < 0 || scoreQuestion > 10) {
                throw new Exception1("Le score doit etre compris entre 1 et 10");
            }
            this.scoreQuestion = scoreQuestion;
        } catch (Exception1 e) {
            e.getMessage();
        }

    }
    public String getQuestionEnonce() {
        return questionEnonce;
    }

}
