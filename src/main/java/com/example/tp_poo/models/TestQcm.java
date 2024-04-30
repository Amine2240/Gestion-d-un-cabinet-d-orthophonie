package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestQcm extends TestQuestionnaire{
   // private Set<QuestionQcm> setQuestionsQcm;
   public TestQcm(Set<QuestionQcm>  listquestionsqcm){
         super.listQuestions = new HashSet<QuestionQcm>(listquestionsqcm); // car elle est une interface dans Testquestionnaire
       //super.listQuestions.addAll(listquestionsqcm);
   }
}
