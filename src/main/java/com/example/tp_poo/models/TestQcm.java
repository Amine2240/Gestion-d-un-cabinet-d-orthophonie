package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestQcm extends TestQuestionnaire{
   // private Set<QuestionQcm> setQuestionsQcm;
   public TestQcm(Set<QuestionQcm>  listquestionsqcm , String nom, String orthogonisteObservation){
       super(nom , orthogonisteObservation);
         super.listQuestions = new HashSet<QuestionQcm>(listquestionsqcm); // car elle est une interface dans Testquestionnaire
       //super.listQuestions.addAll(listquestionsqcm);
   }
    public Set<QuestionQcm> getListQuestionsQcm(){
        return (Set<QuestionQcm>) super.listQuestions;
    }
}
