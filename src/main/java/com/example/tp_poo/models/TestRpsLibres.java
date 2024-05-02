package com.example.tp_poo.models;

import java.util.HashSet;
import java.util.Set;

public class TestRpsLibres extends TestQuestionnaire {
   // Set<QuestionRpsLibres> questionsRpslibresSet;
    public TestRpsLibres(Set<QuestionRpsLibres>  listquestionRpsLibres , String nom, String orthogonisteObservation){
        super(nom , orthogonisteObservation);
        super.listQuestions = new HashSet<>(listquestionRpsLibres);
        //super.listQuestions.addAll(listquestionRpsLibres);
    }


}
