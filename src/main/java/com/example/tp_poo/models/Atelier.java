package com.example.tp_poo.models;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Atelier extends RendezVous{
 private String thematique;
 //we can swithc it to map
    private ArrayList<Integer> numeroDossiersPatients ;

    public Atelier(LocalDate date, LocalTime heureDebut ,  String thematique , Patient patient) {
        super(date, heureDebut  , patient);
        this.thematique = thematique;
    }
}
