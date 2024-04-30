package com.example.tp_poo.models;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class TestQcu extends TestQuestionnaire{
   // private Set<QuestionQcu> setQuestionsQcu;
   public TestQcu(Set<QuestionQcu>  listquestionsqcu){
         super.listQuestions = new HashSet<QuestionQcu>(listquestionsqcu);
      // super.listQuestions.addAll(listquestionsqcu);
   }
}
