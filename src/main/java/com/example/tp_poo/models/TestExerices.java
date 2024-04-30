package com.example.tp_poo.models;

import java.util.ArrayList;

public class TestExerices  extends Test{
    private ArrayList<Exercice> listExercices;



    public double calculerMoyeneExercice(Exercice exercice){
        double moyeneExercices = 0;
        int i = 0;
        for (Exercice exo : listExercices) {
            if (exo.getNomExo().equals(exercice.getNomExo())){
            moyeneExercices = moyeneExercices + exo.scoreExercice;
            i++;
            }
        }
        return  moyeneExercices / i;

    }
    public double calculerScoreTotal(){
        double scoretotal = 0;
        for (Exercice exercice : listExercices) {
            scoretotal = scoretotal + calculerMoyeneExercice(exercice);
        }
        return scoretotal;
    }
}
