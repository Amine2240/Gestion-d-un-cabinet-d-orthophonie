package com.example.tp_poo.models;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class RendezVous {
    protected String observation;
    protected LocalDate date;
    protected LocalTime heureDebut;
    protected LocalTime heureFin;
    protected Patient patient;
    protected Duration duree = Duration.ofMinutes(60);

    public RendezVous(LocalDate date, LocalTime heureDebut   , Patient patient) {
        this.date  = date != null ? date : LocalDate.now();;
        this.heureDebut = heureDebut;
        this.heureFin = heureDebut.plus(duree);
       // this.duree = duree;
        this.patient = patient;
    }

    public void setObservation(String observation) {
        this.observation = observation;

    }
    public LocalTime getHeureDebut(){
        return heureDebut;
    }
    public void setHeureDebut(LocalTime heureDebut){
        this.heureDebut = heureDebut;
    }
    public LocalTime getHeureFin(){
        return heureFin;
    }
    public LocalDate getDate(){
        return date;
    }
    public Duration getDuree(){
        return duree;
    }
    public Patient getPatient(){
        return patient;
    }
}
