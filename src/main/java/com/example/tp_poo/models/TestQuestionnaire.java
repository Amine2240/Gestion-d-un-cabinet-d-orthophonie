package com.example.tp_poo.models;

import java.util.Set;

public abstract class TestQuestionnaire extends Test{
    protected Set<? extends Question> listQuestions; // tout type

    public TestQuestionnaire(String nom, String orthogonisteObservation) {
        super(nom, orthogonisteObservation);
    }

    public Set<? extends Question> getListQuestions() {
        return listQuestions;
    }

    public double calculerScoreTotal(){
        double scoretotal = 0;
        for (Question question : listQuestions) {
            scoretotal = scoretotal + question.scoreQuestion;
        }
        return scoretotal;
    }
}
