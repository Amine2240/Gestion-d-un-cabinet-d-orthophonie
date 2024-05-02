package com.example.tp_poo.models;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;

public abstract class RendezVous {
    protected String observation;
    protected Date date;
    protected Time heure;
    protected Patient patient;
    protected Duration duree = Duration.ofHours(1);

    public RendezVous(Date date, Time heure) {
        this.date = date;
        this.heure = heure;
        //this.patient = patient;{
    }

    public void setObservation(String observation) {
        this.observation = observation;

    }
}
