package com.example.tp_poo.models;

import java.util.List;

public class QuestionQcm extends Question{
    private List<String> listpropositions;
    private List<String> listReponsesPatient;
    private List<String> listReponsesJustes;

    public QuestionQcm(String questionEnonce, int scoreQuestion , List<String> listpropositions , List<String> listReponsesPatient  , List<String> listReponsesJustes) {
        super(questionEnonce , scoreQuestion);
        this.listpropositions = listpropositions;
        this.listReponsesPatient = listReponsesPatient;
        this.listReponsesJustes = listReponsesJustes;

    }
}
