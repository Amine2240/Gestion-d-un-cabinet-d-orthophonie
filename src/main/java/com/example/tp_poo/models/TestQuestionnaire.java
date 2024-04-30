package com.example.tp_poo.models;

import java.util.Set;

public abstract class TestQuestionnaire extends Test{
    protected Set<? extends Question> listQuestions; // tout type

    public double calculerScoreTotal(){
        int scoretotal = 0;
        for (Question question : listQuestions) {
            scoretotal = scoretotal + question.scoreQuestion;
        }
        return scoretotal;
    }
}
