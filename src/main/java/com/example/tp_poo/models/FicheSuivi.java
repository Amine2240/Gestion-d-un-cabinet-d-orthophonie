package com.example.tp_poo.models;

import java.util.ArrayList;

public class FicheSuivi {
    private ArrayList<Objectif> listObjectifs; // elle peut etre set
    private double noteObjectifs; //entre 1 et 5
    private boolean objectifsatteints;
    public FicheSuivi(ArrayList<Objectif> listObjectifs) {
        this.listObjectifs = listObjectifs;
       // this.noteObjectifs = noteObjectifs;
    }

    public void setNoteObjectifs(double noteObjectifs) {
        try {
            if (noteObjectifs < 0 || noteObjectifs > 5) {
                throw new Exception2("La note doit etre comprise entre 1 et 5");
            }
            this.noteObjectifs = noteObjectifs;
        } catch (Exception2 e) {
            e.getMessage();
        }

       // this.noteObjectifs = noteObjectifs;
    }
    public double getNoteObjectifs() {
        return noteObjectifs;
    }
    public void addObjectif( Objectif objectif){
        listObjectifs.add(objectif);
    }
    public boolean getObjectifsatteints() {
        return objectifsatteints;
    }
    public void setObjectifsatteints(boolean objectifsatteints) {
        this.objectifsatteints = objectifsatteints;
    }
    public ArrayList<Objectif> getListObjectifs() {
        return listObjectifs;
    }
}
