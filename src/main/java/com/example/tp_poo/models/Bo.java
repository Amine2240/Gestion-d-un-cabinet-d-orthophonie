package com.example.tp_poo.models;

import java.util.ArrayList;

public class Bo {
    // la classe Bo va contenir 2 constructeurs, un pour le premier (avec lanamnese) et un pour les autres (sans lanamnese)
    private Patient patient;
    private Anamnese anamnese; // soit enfant soit adulte
    private ArrayList<EpreuveClinique> listEpreuvesCliniques;
    private Diagnostic diagnostic;
    private ProjetTherapeutique projetTherapeutique;

    public Bo(Patient patient , Anamnese anamnese , ArrayList<EpreuveClinique> listEpreuvesCliniques , Diagnostic diagnostic , ProjetTherapeutique projetTherapeutique){
        this.patient = patient;
        this.anamnese = anamnese;
        this.listEpreuvesCliniques = listEpreuvesCliniques;
        this.diagnostic = diagnostic;
        this.projetTherapeutique = projetTherapeutique;
    }
    public Bo(Patient patient , ArrayList<EpreuveClinique> listEpreuvesCliniques , Diagnostic diagnostic , ProjetTherapeutique projetTherapeutique){
        this.patient = patient;
        this.listEpreuvesCliniques = listEpreuvesCliniques;
        this.diagnostic = diagnostic;
        this.projetTherapeutique = projetTherapeutique;

    }

    public Diagnostic getDiagnostic(){
        return diagnostic;
    }
    public ProjetTherapeutique getProjetTherapeutique(){
        return projetTherapeutique;
    }
    public Patient getPatient(){
        return patient;
    }
    public Anamnese getAnamnese(){
        return anamnese;
    }
    public ArrayList<EpreuveClinique> getListEpreuvesCliniques(){
        return listEpreuvesCliniques;
    }
}
