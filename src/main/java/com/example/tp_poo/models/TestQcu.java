package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class TestQcu extends TestQuestionnaire{
   // private Set<QuestionQcu> setQuestionsQcu;
   public TestQcu(Set<QuestionQcu>  listquestionsqcu , String nom, String orthogonisteObservation){
       super(nom , orthogonisteObservation);
       super.listQuestions = new HashSet<QuestionQcu>(listquestionsqcu);
      // super.listQuestions.addAll(listquestionsqcu);
   }

    public Set<QuestionQcu> getListQuestionsQcu(){
         return (Set<QuestionQcu>) super.listQuestions;
    }

}
