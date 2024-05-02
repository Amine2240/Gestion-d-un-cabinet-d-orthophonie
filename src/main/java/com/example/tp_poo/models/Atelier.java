package com.example.tp_poo.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Atelier extends RendezVous{
 private String thematique;
 //we can swithc it to map
    private ArrayList<Integer> numeroDossiersPatients ;

    public Atelier(Date date, Time heure ,  String thematique) {
        super(date, heure);
        this.thematique = thematique;
    }
}
