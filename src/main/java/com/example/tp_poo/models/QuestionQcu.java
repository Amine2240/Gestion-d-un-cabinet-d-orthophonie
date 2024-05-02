package com.example.tp_poo.models;

import java.util.List;

public class QuestionQcu extends Question {
    private List<String> listpropositions;
    private String reponsePatient;
    private String reponseJuste;

    public QuestionQcu(String questionEnonce, int scoreQuestion , List<String> listpropositions , String ReponsePatient  , String ReponseJuste) {
        super(questionEnonce, scoreQuestion);
        this.listpropositions = listpropositions;
        this.reponsePatient = ReponsePatient;
        this.reponseJuste = ReponseJuste;
    }
}
