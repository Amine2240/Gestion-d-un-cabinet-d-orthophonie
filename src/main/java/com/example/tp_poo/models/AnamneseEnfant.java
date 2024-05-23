package com.example.tp_poo.models;

import java.util.ArrayList;

public class AnamneseEnfant extends Anamnese{
    private ArrayList<QuestionAnamnese> listQuestions; // questions de type questionAnamnese
    public AnamneseEnfant(String nom ,  ArrayList<QuestionAnamnese> listQuestions) {
        super(nom);
        this.listQuestions = listQuestions;
    }
    public ArrayList<QuestionAnamnese> getListQuestions() {
        return listQuestions;
    }

}
