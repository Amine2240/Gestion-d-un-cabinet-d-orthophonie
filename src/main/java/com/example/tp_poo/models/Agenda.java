package com.example.tp_poo.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable {
    private ArrayList<RendezVous> listRendezVous;
    public Agenda(ArrayList<RendezVous> listRendezVous){
        this.listRendezVous = listRendezVous;
    }
    public ArrayList<RendezVous> getListRendezVous() {
        return listRendezVous;
    }
    public void setListRendezVous(ArrayList<RendezVous> listRendezVous) {
        this.listRendezVous = listRendezVous;
    }

    public void addRendezVous(RendezVous rendezVous){
        listRendezVous.add(rendezVous);
    }
}
