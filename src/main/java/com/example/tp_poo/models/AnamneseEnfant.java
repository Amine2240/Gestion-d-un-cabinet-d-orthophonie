package com.example.tp_poo.models;

import java.util.ArrayList;

public class AnamneseEnfant extends Anamnese{
    private ArrayList<QuestionAnamnese> listQuestions; // questions de type questionAnamnese
    public AnamneseEnfant(ArrayList<QuestionAnamnese> listQuestions) {
        this.listQuestions = listQuestions;
    }
}
