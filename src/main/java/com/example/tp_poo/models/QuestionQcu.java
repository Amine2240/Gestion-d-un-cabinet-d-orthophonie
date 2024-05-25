package com.example.tp_poo.models;

import java.util.List;

public class QuestionQcu extends Question {
    private List<String> listpropositions;
    private String reponsePatient;
    private String reponseJuste;

    public QuestionQcu(String questionEnonce, List<String> listpropositions   , String ReponseJuste) {
        super(questionEnonce);
        this.listpropositions = listpropositions;
        //this.reponsePatient = ReponsePatient;
        this.reponseJuste = ReponseJuste;
    }
    public List<String> getListpropositions() {
        return listpropositions;
    }
    public String getReponseJuste() {
        return reponsePatient;
    }
}
